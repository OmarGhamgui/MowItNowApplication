package com.example.mowitnow.services;

import com.example.mowitnow.entities.Pelouse;
import com.example.mowitnow.entities.Tondeuse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TondeuseServiceImpl implements TondeuseService {

    @Override
    public String executeInstructions(String input) {
        StringBuilder result = new StringBuilder();
        try {
            String line;
            Pelouse pelouse = null;
            Resource resource = new ClassPathResource(input);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (pelouse == null) {
                    // Première ligne : les dimensions de la pelouse
                    int maxX = Integer.parseInt(tokens[0]);
                    int maxY = Integer.parseInt(tokens[1]);
                    pelouse = new Pelouse(maxX, maxY);
                } else {
                    // Lignes suivantes
                    int x = Integer.parseInt(tokens[0]);
                    int y = Integer.parseInt(tokens[1]);
                    char orientation = tokens[2].charAt(0);
                    Tondeuse tondeuse = new Tondeuse(x, y, orientation);

                    String instructions = reader.readLine();
                    for (char instruction : instructions.toCharArray()) {
                        if (instruction == 'D') {
                            tondeuse.tournerDroite();
                        } else if (instruction == 'G') {
                            tondeuse.tournerGauche();
                        } else if (instruction == 'A') {
                            tondeuse.avancer(pelouse);
                        }
                    }

                    result.append(" ").append(tondeuse.getPosition());
                }
            }
            reader.close();
        } catch (IOException e) {
            return e.getMessage();
        }

    return result.toString();
    }
}
