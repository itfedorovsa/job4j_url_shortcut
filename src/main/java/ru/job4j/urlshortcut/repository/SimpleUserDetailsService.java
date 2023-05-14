package ru.job4j.urlshortcut.repository;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.urlshortcut.model.Website;
import ru.job4j.urlshortcut.service.WebsiteService;

import static java.util.Collections.emptyList;

/**
 * UserDetails service
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.04.23
 */
@Service
@AllArgsConstructor
public class SimpleUserDetailsService implements UserDetailsService {

    /**
     * WebsiteService implementation
     */
    private WebsiteService websiteService;

    /**
     * Load Website by username
     *
     * @param username Username. Type {@link java.lang.String}
     * @return UserDetails UserDetails. Type {@link org.springframework.security.core.userdetails.UserDetails}
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Website user = websiteService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }

}