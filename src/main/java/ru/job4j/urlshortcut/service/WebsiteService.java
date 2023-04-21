package ru.job4j.urlshortcut.service;

import lombok.NonNull;
import ru.job4j.urlshortcut.model.Website;

/**
 * Website service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.04.23
 */
public interface WebsiteService {

    Website save(Website website);

    Website findByUsername(@NonNull String username);

}
