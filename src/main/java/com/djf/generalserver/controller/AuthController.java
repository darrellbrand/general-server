package com.djf.generalserver.controller;

import com.djf.generalserver.dto.TokenData;
import com.djf.generalserver.service.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/token")
    public ResponseEntity<TokenData> token(Authentication authentication, HttpServletResponse httpServletResponse) {
        LOG.debug("token requested for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("token generated: {}", token);
        return  new ResponseEntity<>(new TokenData(token),HttpStatus.OK);
    }

}
