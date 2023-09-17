package com.example.mowitnow.controllers;

import com.example.mowitnow.services.TondeuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TondeuseController {

    @Autowired
    private TondeuseService tondeuseService;

    @RequestMapping(value = "/executeInstructions/{input}", method = RequestMethod.GET)
    public String executeInstructions(@PathVariable String input) {
        return tondeuseService.executeInstructions(input);
    }
}
