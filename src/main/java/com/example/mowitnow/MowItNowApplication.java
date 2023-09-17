package com.example.mowitnow;

import com.example.mowitnow.entities.Pelouse;
import com.example.mowitnow.entities.Tondeuse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class MowItNowApplication {


    public static void main(String[] args) {
        SpringApplication.run(MowItNowApplication.class, args);
    }
}
