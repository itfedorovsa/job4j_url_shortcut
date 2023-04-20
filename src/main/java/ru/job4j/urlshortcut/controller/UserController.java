package ru.job4j.urlshortcut.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.job4j.urlshortcut.dto.WebSiteSignupDto;
import ru.job4j.urlshortcut.model.WebSite;
import ru.job4j.urlshortcut.repository.WebsiteRepository;
import ru.job4j.urlshortcut.validation.Operation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.04.23
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private WebsiteRepository websiteRepository;

    private BCryptPasswordEncoder encoder;

    private final ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getSimpleName());

    @PostMapping("/sign-up")
    @Validated(Operation.OnCreate.class)
    public ResponseEntity<WebSiteSignupDto> signUp(@Valid @RequestBody WebSite website) {
        String login = "site" + generateRandomCredential();
        String password = generateRandomCredential();
        website.setUsername(login);
        website.setPassword(encoder.encode(password));
        websiteRepository.save(website);
        WebSiteSignupDto webSiteSignupDto = new WebSiteSignupDto();
        webSiteSignupDto.setSignedUp(true);
        webSiteSignupDto.setPassword(password);
        webSiteSignupDto.setUsername(login);
        return new ResponseEntity<>(webSiteSignupDto, HttpStatus.CREATED);
    }

    /**
     * Generate random credential (for login / password)
     *
     * @return String
     */
    private static String generateRandomCredential() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, 10)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public void exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() {
            {
                put("message", e.getMessage());
                put("type", e.getClass());
            }
        }));
        LOGGER.error(e.getLocalizedMessage());
    }

}
