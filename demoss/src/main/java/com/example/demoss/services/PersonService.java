package com.example.demoss.services;
import com.example.demoss.repositories.PersonFileRepository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadforlistView() throws IOException {
        List<String> lines = repo.readAllines();
        List<String > result = new ArrayList<>();
        for(String line : lines){
            if(line==null  || line.isBlank()) continue;
            String [] parts= line.split(",");
            String name = parts[0];
            String email= parts[1];
            result.add((name+ "-" + email));
        }
        return result;


    }
}
