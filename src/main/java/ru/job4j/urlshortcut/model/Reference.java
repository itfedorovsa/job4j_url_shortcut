package ru.job4j.urlshortcut.model;

import lombok.*;
import lombok.EqualsAndHashCode.Include;
import ru.job4j.urlshortcut.validation.Operation;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Reference model
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
@Table(name = "references")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    @Min(value = 1, message = "Id must be more than 0", groups = {
            Operation.OnUpdate.class, Operation.OnDelete.class
    })
    private int id;

    @NotBlank(message = "Original URL cannot be empty")
    @Column(name = "original_url")
    private String originalUrl;

    @NotBlank(message = "Short URL cannot be empty")
    @Column(name = "shortened_url")
    private String shortenedUrl;

}
