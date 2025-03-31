package org.example.services;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CatDTO {
    private Long id;
    private Date birthDate;
    private String breed;
    private String color;
    private String name;
    private Long ownerId;
}