package ru.job4j.urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.urlshortcut.dto.StatisticShowDto;
import ru.job4j.urlshortcut.model.Reference;
import ru.job4j.urlshortcut.service.ReferenceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Statistic controller
 *
 * @author itfedorovsa (itfedrovsa@gmail.com)
 * @version 1.0
 * @since 20.04.23
 */
@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticController {

    private ReferenceService referenceService;

    @GetMapping("/common-statistic")
    public ResponseEntity<List<StatisticShowDto>> commonStatistic() {
        List<Reference> allRefs = referenceService.findAll();
        List<StatisticShowDto> statistics = new ArrayList<>();
        for (Reference reference : allRefs) {
            statistics.add(new StatisticShowDto(reference.getOriginalUrl(), reference.getCallCounter()));
        }
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
