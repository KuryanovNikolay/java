package org.example.controllers;

import java.util.Date;

public interface OwnerController {
    void createOwner(String name, Date birthdate);
    void updateName(Integer id, String name);
    void updateBirthdate(Integer id, Date birthdate);
    void deleteOwner(Integer id);
}