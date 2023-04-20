package ru.job4j.urlshortcut.dto;

import lombok.*;

/**
 * WebSite sign up DTO
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.04.23
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WebSiteSignupDto {

    private boolean isSignedUp;

    private String username;

    private String password;

}

