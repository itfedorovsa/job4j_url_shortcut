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

    private boolean isSignedUp;

    private String username;

    private String password;

}

