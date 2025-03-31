package org.example.services;


import org.example.DAO.OwnerDAO;
import org.example.DAO.entities.Owner;

import java.util.Date;

public class OwnerServiceImpl implements OwnerService {
    private final OwnerDAO ownerDAO = new OwnerDAO();

    @Override
    public void createOwner(String name, Date birthdate) {
        Owner owner = new Owner();
        owner.setName(name);
        owner.setBirthDate(new java.sql.Date(birthdate.getTime()));
        ownerDAO.save(owner);
    }

    @Override
    public void changeName(Integer id, String name) {
        Owner owner = ownerDAO.get(id);
        owner.setName(name);
        ownerDAO.update(owner);
    }

    @Override
    public void changeBirthdate(Integer id, Date birthdate) {
        Owner owner = ownerDAO.get(id);
        owner.setBirthDate(new java.sql.Date(birthdate.getTime()));
        ownerDAO.update(owner);
    }

    @Override
    public void deleteOwner(Integer id) {
        Owner owner = ownerDAO.get(id);
        ownerDAO.delete(owner);
    }
}