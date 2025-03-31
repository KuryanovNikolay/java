package org.example.services;

import org.example.entities.Cat;
import org.example.entities.Owner;
import org.example.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerDTO getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        return convertToDTO(owner);
    }

    public List<OwnerDTO> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OwnerDTO saveOwner(OwnerDTO ownerDTO) {
        Owner owner = convertToEntity(ownerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return convertToDTO(savedOwner);
    }

    public OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setName(ownerDTO.getName());
        owner.setBirthDate(ownerDTO.getBirthDate());
        Owner updatedOwner = ownerRepository.save(owner);
        return convertToDTO(updatedOwner);
    }

    public List<CatDTO> getCatsByOwnerId(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner not found"));
        return owner.getCats().stream().map(this::convertCatToDTO).collect(Collectors.toList());
    }

    private CatDTO convertCatToDTO(Cat cat) {
        CatDTO dto = new CatDTO();
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setBirthDate(cat.getBirthDate());
        dto.setBreed(cat.getBreed());
        dto.setColor(String.valueOf(cat.getColor()));
        dto.setOwnerId(cat.getOwner().getId());
        return dto;
    }
    public List<CatDTO> getOwnerCats(Long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        return owner.getCats().stream().map(this::convertCatToDTO).collect(Collectors.toList());
    }

    public void deleteOwner(Long id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Owner not found");
        }
    }

    private OwnerDTO convertToDTO(Owner owner) {
        OwnerDTO dto = new OwnerDTO();
        dto.setId(owner.getId());
        dto.setName(owner.getName());
        dto.setBirthDate(owner.getBirthDate());
        return dto;
    }

    private Owner convertToEntity(OwnerDTO dto) {
        Owner owner = new Owner();
        owner.setId(dto.getId());
        owner.setName(dto.getName());
        owner.setBirthDate(dto.getBirthDate());
        return owner;
    }
}

