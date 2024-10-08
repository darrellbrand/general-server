package com.djf.generalserver.controller;

import com.djf.generalserver.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @GetMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("token requested for user: {}", authentication.getName());

        String token = tokenService.generateToken(authentication);
        LOG.debug("token generated: {}", token);
        return token;

    }

}
