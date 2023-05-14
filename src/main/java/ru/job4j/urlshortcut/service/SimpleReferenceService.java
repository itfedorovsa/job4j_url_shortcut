package ru.job4j.urlshortcut.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.job4j.urlshortcut.model.Reference;
import ru.job4j.urlshortcut.repository.ReferenceRepository;

import java.util.List;
import java.util.Optional;

/**
 * Reference service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.04.23
 */
@Service
@AllArgsConstructor
public class SimpleReferenceService implements ReferenceService {

    /**
     * ReferenceRepository implementation
     */
    private ReferenceRepository referenceRepository;

    /**
     * Save reference
     *
     * @param reference Reference. Type {@link ru.job4j.urlshortcut.model.Reference}
     * @return Reference. Type {@link ru.job4j.urlshortcut.model.Reference}
     */
    @Override
    public Reference save(Reference reference) {
        return referenceRepository.save(reference);
    }

    /**
     * Find all references
     *
     * @return List of Reference. Type {@link java.util.List<ru.job4j.urlshortcut.model.Reference>}
     */
    @Override
    public List<Reference> findAll() {
        return referenceRepository.findAll();
    }

    /**
     * Find reference by short url
     *
     * @param shortenedUrl Short url. Type {@link java.lang.String}
     * @return Optional of Reference. Type {@link java.util.Optional<ru.job4j.urlshortcut.model.Reference>}
     */
    @Override
    public Optional<Reference> findByShortenedUrl(@NonNull String shortenedUrl) {
        return referenceRepository.findByShortenedUrl(shortenedUrl);
    }

    /**
     * Increment the counter of the number of link calls
     *
     * @param referenceId Reference id. Type {@link java.lang.Integer}
     * @return int
     */
    @Override
    public int incrementCounter(Integer referenceId) {
        return referenceRepository.incrementCounter(referenceId);
    }

}
