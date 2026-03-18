package com.example.demolistview.services;

// personon se encarga en comunicacarse con el archivo de persistencia
// negocios lo que debe de hacer tu aplicacion las reglas


import com.example.demolistview.repositories.PersonFileRepository;
import javafx.fxml.FXML;
import org.w3c.dom.ls.LSInput;

import javax.xml.validation.Validator;
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
                result.add(name + " - " + correo + "-" + edad );
            }
        }

        return result;
    }

    public void updatePerson(int index,String name, String email, int edad) throws IOException {

validatePerson(name, email, edad);
        List<String > listaOriginal=repo.readAllLines();
        List<String>cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line); // esta linea esta buena, ya que no es null.
            }
        }
        cleanLines.set(index,name+","+email+","+edad+",");
        repo.saveFile(cleanLines);
    }

    public void addPerson(String name, String email, int  edad) throws IOException {
        validatePerson(name, email, edad);
        String nameNoComa = name.replace(",", "");
        String emailNoComa = email.replace(",", "");

        repo.appendNewLine(nameNoComa + "," + emailNoComa + "," + edad);

    }

    public void removePerson(int index) throws IOException{
        List<String > listaOriginal=repo.readAllLines();
        List<String> clearLines=new ArrayList<>();
        for(String line : listaOriginal){
            if (line!=null && !line.isBlank()){
                clearLines.add(line);
            }
        }
        clearLines.remove(index);
        repo.saveFile(clearLines);
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