package ru.job4j.urlshortcut.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Website sign up DTO
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.04.23
 */
@Getter
@Setter
public class WebsiteSignupDto {

    /**
     * Signed up / Isn't signed up
     */
    private boolean isSignedUp;

    /**
     * Username (login)
     */
    private String username;

    /**
     * Password
     */
    private String password;

}

