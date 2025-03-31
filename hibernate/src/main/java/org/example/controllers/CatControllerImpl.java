package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.DAO.entities.Owner;
import org.example.services.CatService;

import java.util.Date;

@RequiredArgsConstructor
public class CatControllerImpl implements CatController{
    private final CatService catService;
    @Override
    public void createCat(String name, Date birthdate, String color) {
        catService.createCat(name, birthdate, color);
    }

    @Override
    public void updateName(Integer id, String name) {
        catService.changeName(id, name);
    }

    @Override
    public void updateBreed(Integer id, String breed) {
        catService.changeBreed(id, breed);
    }

    @Override
    public void updateColor(Integer id, String color) {
        catService.changeColor(id, color);
    }

    @Override
    public void updateOwner(Integer id, Owner owner) {
        catService.changeOwner(id, owner);
    }

    @Override
    public void addFriend(Integer catId1, Integer catId2) {
        catService.addFriend(catId1, catId2);
    }

    @Override
    public void deleteCat(Integer id) {
        catService.deleteCat(id);
    }
}