package com.djf.generalserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AIController {

    @CrossOrigin(origins = "https://inventory-frontend-62sl.onrender.com", allowCredentials = "true")
     @GetMapping("/api/ai/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", "FFFFFFFFFFFFFFFFFFFFFFFF");
    }


}
