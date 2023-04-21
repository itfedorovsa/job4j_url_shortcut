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

    private ReferenceRepository referenceRepository;

    @Override
    public Reference save(Reference reference) {
        return referenceRepository.save(reference);
    }

    @Override
    public List<Reference> findAll() {
        return referenceRepository.findAll();
    }

    @Override
    public Optional<Reference> findByShortenedUrl(@NonNull String shortenedUrl) {
        return referenceRepository.findByShortenedUrl(shortenedUrl);
    }

    @Override
    public int incrementCounter(Integer id) {
        return referenceRepository.incrementCounter(id);
    }

}
