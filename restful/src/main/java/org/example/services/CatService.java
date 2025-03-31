package org.example.services;

import org.example.entities.Cat;
import org.example.entities.CatColor;
import org.example.entities.Owner;
import org.example.repositories.CatRepository;
import org.example.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public CatDTO getCatById(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow(() -> new RuntimeException("Cat not found"));
        return convertToDTO(cat);
    }

    public List<CatDTO> getAllCats() {
        List<Cat> cats = catRepository.findAll();
        return cats.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CatDTO saveCat(CatDTO catDTO) {
        Cat cat = convertToEntity(catDTO);
        Cat savedCat = catRepository.save(cat);
        return convertToDTO(savedCat);
    }

    public CatDTO updateCat(Long id, CatDTO catDTO) {
        Cat cat = catRepository.findById(id).orElseThrow(() -> new RuntimeException("Cat not found"));
        cat.setName(catDTO.getName());
        cat.setBirthDate(catDTO.getBirthDate());
        cat.setBreed(catDTO.getBreed());
        cat.setColor(CatColor.valueOf(catDTO.getColor()));
        Cat updatedCat = catRepository.save(cat);
        return convertToDTO(updatedCat);
    }

    public List<CatDTO> getCatsByColor(String color) {
        List<Cat> cats = catRepository.findByColor(color);
        return cats.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<CatDTO> getCatsByName(String name) {
        List<Cat> cats = catRepository.findByName(name);
        return cats.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<CatDTO> getCatsByBirthDate(Date birthDate) {
        List<Cat> cats = catRepository.findByBirthDate(birthDate);
        return cats.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void deleteCat(Long id) {
        if (catRepository.existsById(id)) {
            catRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cat not found");
        }
    }

    private CatDTO convertToDTO(Cat cat) {
        CatDTO dto = new CatDTO();
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setBirthDate(cat.getBirthDate());
        dto.setBreed(cat.getBreed());
        dto.setColor(cat.getColor().getColor());
        dto.setOwnerId(cat.getOwner().getId());
        return dto;
    }



    private Cat convertToEntity(CatDTO dto) {
        Cat cat = new Cat();
        cat.setName(dto.getName());
        cat.setBirthDate(dto.getBirthDate());
        cat.setBreed(dto.getBreed());
        CatColor color = CatColor.valueOf(dto.getColor());
        cat.setColor(color);
        Owner owner = ownerRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        cat.setOwner(owner);
        return cat;
    }
}

