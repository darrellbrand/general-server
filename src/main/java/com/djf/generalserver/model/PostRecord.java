package com.djf.generalserver.model;


import org.springframework.data.annotation.Id;

public record PostRecord(@Id Integer id, String title, String content) {
}
