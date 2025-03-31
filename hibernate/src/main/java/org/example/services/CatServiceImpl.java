package org.example.services;



import org.example.DAO.CatDAO;
import org.example.DAO.CatFriendDAO;
import org.example.DAO.entities.Cat;
import org.example.DAO.entities.CatFriend;
import org.example.DAO.entities.Owner;

import java.awt.*;
import java.util.Date;

public class CatServiceImpl implements CatService {
    private final CatDAO catDAO = new CatDAO();
    private final CatFriendDAO catFriendDAO = new CatFriendDAO();

    @Override
    public void createCat(String name, Date birthdate, String color) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setBirthDate(birthdate);
        cat.setColor(Color.decode(color));
        catDAO.save(cat);
    }

    @Override
    public void changeName(Integer id, String name) {
        Cat cat = catDAO.get(id);
        cat.setName(name);
        catDAO.update(cat);
    }

    @Override
    public void changeBreed(Integer id, String breed) {
        Cat cat = catDAO.get(id);
        cat.setBreed(breed);
        catDAO.update(cat);
    }

    @Override
    public void changeColor(Integer id, String color) {
        Cat cat = catDAO.get(id);
        cat.setColor(Color.decode(color));
        catDAO.update(cat);
    }

    @Override
    public void changeOwner(Integer id, Owner owner) {
        Cat cat = catDAO.get(id);
        cat.setOwnerId(owner.getId());
        catDAO.update(cat);
    }

    @Override
    public void addFriend(Integer catId1, Integer catId2) {
        Cat cat1 = catDAO.get(catId1);
        Cat cat2 = catDAO.get(catId2);
        CatFriend catFriend = new CatFriend();
        catFriend.setCat1(cat1);
        catFriend.setCat2(cat2);
        catFriendDAO.save(catFriend);
    }

    @Override
    public void deleteCat(Integer id) {
        Cat cat = catDAO.get(id);
        catDAO.delete(cat);
    }
}