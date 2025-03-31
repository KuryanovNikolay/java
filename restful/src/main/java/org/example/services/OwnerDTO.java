package org.example.services;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class OwnerDTO {
    private Long id;
    private Date birthDate;
    private String name;
}
