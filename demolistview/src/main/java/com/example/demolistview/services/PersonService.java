package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            if (parts.length >= 3) {
                String name = parts[0].trim();
                String correo = parts[1].trim();
                String edad = parts[2].trim();
                result.add(name + " - " + correo + " (" + edad + " años)");
            }
        }

        return result;
    }

    public void addPerson(String name, String email, int edad) throws IOException {
        validatePerson(name, email, edad);
        String nameNoComa = name.replace(",", "");
        String emailNoComa = email.replace(",", "");

        repo.appendNewLine(nameNoComa + "," + emailNoComa + "," + edad);
    }

    private void validatePerson(String name, String email, int edad) {
        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres");
        }
        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El formato del correo es incorrecto");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("Solo se permiten personas mayores de 18 años");
        }
        if (edad > 120) {
            throw new IllegalArgumentException("La edad no es válida (máximo 120)");
        }
    }
}