package ru.job4j.urlshortcut.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Statistic show DTO
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.04.23
 */
@Getter
@Setter
@AllArgsConstructor
public class StatisticShowDto {

    private String originalUrl;

    private int callCounter;

}
