package ru.job4j.urlshortcut.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.job4j.urlshortcut.model.Website;
import ru.job4j.urlshortcut.repository.WebsiteRepository;

/**
 * Website service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.04.23
 */
@Service
@AllArgsConstructor
public class SimpleWebsiteService implements WebsiteService {

    private WebsiteRepository websiteRepository;

    @Override
    public Website save(Website website) {
        return websiteRepository.save(website);
    }

    @Override
    public Website findByUsername(@NonNull String username) {
        return websiteRepository.findByUsername(username);
    }

}
