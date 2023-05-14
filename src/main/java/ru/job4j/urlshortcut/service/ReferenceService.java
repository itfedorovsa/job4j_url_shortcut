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

    /**
     * Save reference
     *
     * @param reference Reference. Type {@link ru.job4j.urlshortcut.model.Reference}
     * @return Reference. Type {@link ru.job4j.urlshortcut.model.Reference}
     */
    Reference save(Reference reference);

    /**
     * Find all references
     *
     * @return List of Reference. Type {@link java.util.List<ru.job4j.urlshortcut.model.Reference>}
     */
    List<Reference> findAll();

    /**
     * Find reference by short url
     *
     * @param shortenedUrl Short url. Type {@link java.lang.String}
     * @return Optional of Reference. Type {@link java.util.Optional<ru.job4j.urlshortcut.model.Reference>}
     */
    Optional<Reference> findByShortenedUrl(@NonNull String shortenedUrl);

    /**
     * Increment the counter of the number of link calls
     *
     * @param referenceId Reference id. Type {@link java.lang.Integer}
     * @return int
     */
    int incrementCounter(Integer referenceId);

}
