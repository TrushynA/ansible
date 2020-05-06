package com.example.graph.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@RestController
public class GraphController {

    @PostMapping("/post")
    public String createGraph(@RequestParam("file") MultipartFile file) {
        String gotString;
        try {
            gotString = new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error extracting text data, " + e);
            return null;
        }

        return gotString;
    }

    @GetMapping("/get")
    public String getMethod() {
        return "Tehtelka, Privet";
    }
}
