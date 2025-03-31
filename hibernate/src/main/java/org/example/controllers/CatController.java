package org.example.controllers;



import org.example.DAO.entities.Owner;

import java.util.Date;

public interface CatController {
    void createCat(String name, Date birthdate, String color);
    void updateName(Integer id, String name);
    void updateBreed(Integer id, String breed);
    void updateColor(Integer id, String color);
    void updateOwner(Integer id, Owner owner);
    void addFriend(Integer catId1, Integer catId2);
    void deleteCat(Integer id);
}