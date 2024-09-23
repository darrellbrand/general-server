package com.djf.generalserver.dto;

import lombok.Data;

@Data
public class TokenData {
    public TokenData(String token) {
        this.token = token;
    }

    String token;
}
