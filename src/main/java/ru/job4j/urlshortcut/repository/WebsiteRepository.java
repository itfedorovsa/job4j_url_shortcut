package ru.job4j.urlshortcut.repository;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.urlshortcut.model.Website;

/**
 * Website Spring Data repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.04.23
 */
public interface WebsiteRepository extends CrudRepository<Website, Integer> {

    Website findByUsername(@NonNull String username);

}