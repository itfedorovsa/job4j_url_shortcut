package ru.job4j.urlshortcut.service;

import lombok.NonNull;
import ru.job4j.urlshortcut.model.Reference;

import java.util.List;
import java.util.Optional;

/**
 * Reference service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.04.23
 */
public interface ReferenceService {

    Reference save(Reference reference);

    List<Reference> findAll();

    Optional<Reference> findByShortenedUrl(@NonNull String shortenedUrl);

    int incrementCounter(Integer id);

}
