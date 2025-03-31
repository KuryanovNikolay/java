package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.services.OwnerService;

import java.util.Date;

@RequiredArgsConstructor
public class OwnerControllerImpl implements OwnerController{
    private final OwnerService ownerService;
    @Override
    public void createOwner(String name, Date birthdate) {
        ownerService.createOwner(name, birthdate);
    }

    @Override
    public void updateName(Integer id, String name) {
        ownerService.changeName(id, name);
    }

    @Override
    public void updateBirthdate(Integer id, Date birthdate) {
        ownerService.changeBirthdate(id, birthdate);
    }

    @Override
    public void deleteOwner(Integer id) {
        ownerService.deleteOwner(id);
    }
}