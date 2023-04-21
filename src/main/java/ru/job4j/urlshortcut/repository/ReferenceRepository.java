package ru.job4j.urlshortcut.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.urlshortcut.model.Reference;

import java.util.List;
import java.util.Optional;

/**
 * Reference Spring Data repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 20.04.23
 */
public interface ReferenceRepository extends CrudRepository<Reference, Integer> {

    Optional<Reference> findByShortenedUrl(@NonNull String shortenedUrl);

    List<Reference> findAll();

    @Modifying
    @Query(value = "UPDATE refers SET call_counter = call_counter + 1 WHERE id = ?1", nativeQuery = true)
    int incrementCounter(Integer id);

}