package org.example.services;

import java.util.Date;

public interface OwnerService {
    void createOwner(String name, Date birthdate);

    void changeName(Integer id, String name);

    void changeBirthdate(Integer id, Date birthdate);

    void deleteOwner(Integer id);
}