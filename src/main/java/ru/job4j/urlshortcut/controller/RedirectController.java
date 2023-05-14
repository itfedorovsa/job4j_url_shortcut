package ru.job4j.urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.urlshortcut.dto.ShortReferenceDto;
import ru.job4j.urlshortcut.model.Reference;
import ru.job4j.urlshortcut.service.ReferenceService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Redirect controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 20.04.23
 */
@RestController
@RequestMapping("/redirects")
@AllArgsConstructor
public class RedirectController {

    private ReferenceService referenceService;

    /**
     * Convert url from short to long
     *
     * @param shortReferenceDto ShortReferenceDto. Type {@link ru.job4j.urlshortcut.dto.ShortReferenceDto}
     * @return ResponseEntity<String>
     */
    @Transactional
    @GetMapping("/redirect")
    public ResponseEntity<String> convertUrl(@Valid @RequestBody ShortReferenceDto shortReferenceDto) {
        Optional<Reference> refByShortenedUrl = referenceService.findByShortenedUrl(shortReferenceDto.getShortenedUrl());
        if (refByShortenedUrl.isEmpty()) {
            throw new NoSuchElementException("Couldn't find the Reference by this Shortened Url.");
        }
        referenceService.incrementCounter(refByShortenedUrl.get().getId());
        return new ResponseEntity<>(refByShortenedUrl.get().getOriginalUrl(), HttpStatus.TEMPORARY_REDIRECT);
    }

}
