package com.djf.generalserver.controller;

import com.djf.generalserver.service.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @GetMapping("/token")
    public ResponseEntity<String> token(Authentication authentication, HttpServletResponse httpServletResponse) {
        LOG.debug("token requested for user: {}", authentication.getName());

        String token = tokenService.generateToken(authentication);
        Cookie cookie = new Cookie("token",token);
        cookie.setHttpOnly(true); // Not accessible via JavaScript
        cookie.setMaxAge(60 * 60); // 1 hour
        cookie.setSecure(true); // Only sent o
        httpServletResponse.addCookie(cookie);
        LOG.debug("token generated: {}", token);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
