package com.acme.hello.platform.profiles.domain.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Represents a developer in the system.
 * <p>
 *     This entity contains information about a developer, including their name, email, and other relevant details.
 *     It also tracks the number of times the developer has been greated in the system.
 * </p>
 * <p>
 *     The identifier is a UUID that uniquely identifies the developer in the system.
 * </p>
 * @author Gabriel Vilchez Vite
 * @version 1.0.0
 * */
public class Developer {
    private final UUID id;

    private String firstName;
    private String lastName;

    private static int greetingsCount = 0;

    private static final int FIRST_NAME_MAX_LENGTH = 35;
    private static final int LAST_NAME_MAX_LENGTH = 40;

    public Developer(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isBlank()) {
            throw new IllegalArgumentException("First name must be null or empty.");
        }
        if (StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Last name must be null or empty.");
        }
        if (firstName.length() > FIRST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("First name must not exceed " + FIRST_NAME_MAX_LENGTH + " characters.");
        }
        if (lastName.length() > LAST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Last name must not exceed " + LAST_NAME_MAX_LENGTH + " characters.");
        }
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isBlank(firstName)) {
            throw new IllegalArgumentException("First name must be null or empty.");
        }
        if (firstName.length() > FIRST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("First name must not exceed " + FIRST_NAME_MAX_LENGTH + " characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isBlank(lastName)) {
            throw new IllegalArgumentException("Last name must be null or empty.");
        }
        if (lastName.length() > LAST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Last name must not exceed " + LAST_NAME_MAX_LENGTH + " characters.");
        }
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public void incrementGreetingsCount() {
        greetingsCount++;
    }

    public boolean isAnyNameBlank() {
        return StringUtils.isBlank(this.firstName) || StringUtils.isBlank(this.lastName);
    }
}
