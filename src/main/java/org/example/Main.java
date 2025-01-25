package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Démarrer l'application Spring Boot
        SpringApplication.run(Main.class, args);

        // Message de bienvenue (optionnel)
        System.out.println("L'application Spring Boot avec ActiveMQ a démarré avec succès !");
    }
}