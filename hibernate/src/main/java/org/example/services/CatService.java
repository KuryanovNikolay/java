package org.example.services;



import org.example.DAO.entities.Owner;

import java.util.Date;

public interface CatService {
    void createCat(String name, Date birthdate, String color);

    void changeName(Integer id, String name);

    void changeBreed(Integer id, String breed);

    void changeColor(Integer id, String color);

    void changeOwner(Integer id, Owner owner);

    void addFriend(Integer catId1, Integer catId2);

    void deleteCat(Integer id);
}