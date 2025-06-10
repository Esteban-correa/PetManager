package dev.ecr.graphqlqbe.Utilities;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "✅ API GraphQL funcionando correctamente.";
    }
}