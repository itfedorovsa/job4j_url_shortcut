package ru.job4j.urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.urlshortcut.dto.ShortReferenceDto;
import ru.job4j.urlshortcut.model.Reference;
import ru.job4j.urlshortcut.service.ReferenceService;
import ru.job4j.urlshortcut.validation.Operation;

import javax.validation.Valid;

import static ru.job4j.urlshortcut.util.RandomValue.generateRandomValue;

/**
 * Reference converter controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 20.04.23
 */
@RestController
@RequestMapping("/converters")
@AllArgsConstructor
public class RefConverter {

    private ReferenceService referenceService;

    @PostMapping("/convert-url")
    @Validated(Operation.OnCreate.class)
    public ResponseEntity<ShortReferenceDto> convertUrl(@Valid @RequestBody Reference reference) {
        String shortenedUrl = generateRandomValue(7);
        reference.setShortenedUrl(shortenedUrl);
        referenceService.save(reference);
        ShortReferenceDto shortReferenceDto = new ShortReferenceDto();
        shortReferenceDto.setShortenedUrl(shortenedUrl);
        return new ResponseEntity<>(shortReferenceDto, HttpStatus.CREATED);
    }

}
