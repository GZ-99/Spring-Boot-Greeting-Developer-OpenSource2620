package com.acme.hello.platform.profiles.interfaces.rest.assemblers;

import com.acme.hello.platform.profiles.domain.model.entity.Developer;
import com.acme.hello.platform.profiles.interfaces.rest.resources.GreetDeveloperResponse;

public class GreetDeveloperAssembler {
    public static GreetDeveloperResponse
    toResponseFromEntity(Developer entity) {
        return new GreetDeveloperResponse(
                entity.getId(), entity.getFullName()
        );
    }
}
