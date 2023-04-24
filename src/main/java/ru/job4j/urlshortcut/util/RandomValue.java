package ru.job4j.urlshortcut.util;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Random value class
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 20.04.23
 */
public class RandomValue {

    /**
     * Generate random value (for login, password etc.)
     *
     * @return String
     */
    public static String generateRandomValue(int symbols) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, symbols)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }

}
