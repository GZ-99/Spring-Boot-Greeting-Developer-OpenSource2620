package com.acme.hello.platform.profiles.interfaces.rest.controllers;

import com.acme.hello.platform.profiles.domain.model.entity.Developer;
import com.acme.hello.platform.profiles.interfaces.rest.assemblers.GreetDeveloperAssembler;
import com.acme.hello.platform.profiles.interfaces.rest.resources.GreetDeveloperRequest;
import com.acme.hello.platform.profiles.interfaces.rest.resources.GreetDeveloperResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    @GetMapping
    public String greeting() {
        return "Hello Word"; //http://localhost:60000/api/v1/greetings
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> greetingByName(@PathVariable("name") String name) {
        if (name.length() < 3) {
            return ResponseEntity.badRequest()
                    .body("Name must have at least 3 characters"); //http://localhost:60000/api/v1/greetings/Ga
        }
        return ResponseEntity.ok("Hello: " + name + "!"); //http://localhost:60000/api/v1/greetings/Gabriel
    }

    @GetMapping("/helloparameter")
    public ResponseEntity<String> greetingByParameter1(@RequestParam String firstName,
                                      @RequestParam String lastName) {
        if (firstName.isBlank() || lastName.isBlank()) {
            return ResponseEntity.badRequest()
                    .body("Name is required"); //http://localhost:60000/api/v1/greetings/helloparameter?firstName=&lastName=
        }
        return ResponseEntity
                .ok()
                .header("Course", "Open Source")
                .body("Hello " + firstName + " " + lastName + "!"); //http://localhost:60000/api/v1/greetings/helloparameter?firstName=Gabriel&lastName=Vilchez
    }

    @GetMapping("/hello")
    public String greetingByParameter(@RequestParam String firstName,
                                      @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + "!"; //http://localhost:60000/api/v1/greetings/hello?firstName=Gabriel&lastName=Vilchez
    }

    @GetMapping("/hola") //Yo hice esto
    public String greetingByLanguage(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam int language) {
        if (language == 1) {
            return "Hello " + firstName + " " + lastName + "!"; //http://localhost:60000/api/v1/greetings/hola?firstName=Gabriel&lastName=Vilchez&language=1
        }
        else if (language == 2) {
            return "Hola " + firstName + " " + lastName + "!"; //http://localhost:60000/api/v1/greetings/hola?firstName=Gabriel&lastName=Vilchez&language=2
        }
        else if (language == 3) {
            return "Kon'nichiwa " + firstName + " " + lastName + "!"; //http://localhost:60000/api/v1/greetings/hola?firstName=Gabriel&lastName=Vilchez&language=3
        }
        else if (language == 4) {
            return "Nǐ hǎo " + firstName + " " + lastName + "!"; //http://localhost:60000/api/v1/greetings/hola?firstName=Gabriel&lastName=Vilchez&language=4
        }
        else {
            return "Idioma desconocido!"; //http://localhost:60000/api/v1/greetings/hola?firstName=Gabriel&lastName=Vilchez&language=5
        }
    }

    @PostMapping
    public ResponseEntity<GreetDeveloperResponse>
            greetDeveloper(@Valid @RequestBody GreetDeveloperRequest request) {
        var developer = new Developer(request.firstName(),
                request.lastName());
        developer.incrementGreetingsCount();
        var response = GreetDeveloperAssembler
                .toResponseFromEntity(developer);
        return ResponseEntity.created(URI.create("/api/v1/greetings/"+developer.getId()))
                .body(response);
    }
}
