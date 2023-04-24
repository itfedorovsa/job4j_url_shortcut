package ru.job4j.urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.urlshortcut.dto.WebsiteSignupDto;
import ru.job4j.urlshortcut.model.Website;
import ru.job4j.urlshortcut.service.WebsiteService;
import ru.job4j.urlshortcut.validation.Operation;

import javax.validation.Valid;

import static ru.job4j.urlshortcut.util.RandomValue.generateRandomValue;

/**
 * Registration controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.04.23
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class Registration {

    private WebsiteService websiteService;

    private BCryptPasswordEncoder encoder;

    @PostMapping("/sign-up")
    @Validated(Operation.OnCreate.class)
    public ResponseEntity<WebsiteSignupDto> signUp(@Valid @RequestBody Website website) {
        String login = "site" + generateRandomValue(10);
        String password = generateRandomValue(10);
        website.setUsername(login);
        website.setPassword(encoder.encode(password));
        websiteService.save(website);
        WebsiteSignupDto webSiteSignupDto = new WebsiteSignupDto();
        webSiteSignupDto.setSignedUp(true);
        webSiteSignupDto.setPassword(password);
        webSiteSignupDto.setUsername(login);
        return new ResponseEntity<>(webSiteSignupDto, HttpStatus.CREATED);
    }

}
