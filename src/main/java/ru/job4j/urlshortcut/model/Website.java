package ru.job4j.urlshortcut.model;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import ru.job4j.urlshortcut.validation.Operation;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Website model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.04.23
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "websites")
public class Website {

    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    @Min(value = 1, message = "Id must   be more than 0", groups = {
            Operation.OnUpdate.class, Operation.OnDelete.class
    })
    private int id;

    /**
     * Website name
     */
    @NotBlank(message = "Site URL cannot be empty")
    private String site;

    /**
     * Username (login)
     */
    @NotBlank(message = "Login cannot be empty", groups = {
            Operation.OnUpdate.class, Operation.OnDelete.class
    })
    private String username;

    /**
     * Password
     */
    @NotBlank(message = "Password cannot be empty", groups = {
            Operation.OnUpdate.class, Operation.OnDelete.class
    })
    private String password;

}
