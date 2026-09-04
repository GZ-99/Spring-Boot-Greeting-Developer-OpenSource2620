package com.acme.hello.platform.profiles.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GreetDeveloperRequest(
        @NotBlank(message = "First name cannot be blank")
        @Size(max = 35, message = "First name cannot exceed 35 characters")
        String firstName,
        @NotBlank(message = "Last name cannot be blank")
        @Size(max = 35, message = "Last name cannot exceed 35 characters")
        String lastName
) {
}
