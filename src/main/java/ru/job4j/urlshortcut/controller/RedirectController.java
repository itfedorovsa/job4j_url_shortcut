package ru.job4j.urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.urlshortcut.dto.OriginalReferenceDto;
import ru.job4j.urlshortcut.dto.ShortReferenceDto;
import ru.job4j.urlshortcut.model.Reference;
import ru.job4j.urlshortcut.service.ReferenceService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.NoSuchElementException;

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

    @Transactional
    @GetMapping("/redirect")
    public ResponseEntity<OriginalReferenceDto> convertUrl(@Valid @RequestBody ShortReferenceDto shortReferenceDto) {
        Reference refByShortenedUrl = referenceService.findByShortenedUrl(shortReferenceDto.getShortenedUrl())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Reference by this Shortened Url."));
        OriginalReferenceDto originalReferenceDto = new OriginalReferenceDto();
        originalReferenceDto.setOriginalUrl(refByShortenedUrl.getOriginalUrl());
        referenceService.incrementCounter(refByShortenedUrl.getId());
        return new ResponseEntity<>(originalReferenceDto, HttpStatus.FOUND);
    }

}
