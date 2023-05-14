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

    /**
     * Save website
     *
     * @param website Website. Type {@link ru.job4j.urlshortcut.model.Website}
     * @return Website. Type {@link ru.job4j.urlshortcut.model.Website}
     */
    Website save(Website website);

    /**
     * Find website by username
     *
     * @param username Username. Type {@link java.lang.String}
     * @return Website. Type {@link ru.job4j.urlshortcut.model.Website}
     */
    Website findByUsername(@NonNull String username);

}
