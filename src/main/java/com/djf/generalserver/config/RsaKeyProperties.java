package com.djf.generalserver.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@org.springframework.boot.context.properties.ConfigurationProperties(prefix="rsa")
public record RsaKeyProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

}
