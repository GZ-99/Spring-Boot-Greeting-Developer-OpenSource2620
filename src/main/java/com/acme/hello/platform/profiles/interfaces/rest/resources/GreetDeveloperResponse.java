package com.acme.hello.platform.profiles.interfaces.rest.resources;

import java.util.UUID;

public record GreetDeveloperResponse(
        UUID id, String fullName
) {
}
