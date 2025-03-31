package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.services.CatDTO;
import org.example.services.OwnerDTO;
import org.example.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@AllArgsConstructor
public class OwnerController {
    @Autowired
    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO){
        OwnerDTO savedOwner = ownerService.saveOwner(ownerDTO);
        return ResponseEntity.ok(savedOwner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id){
        OwnerDTO owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(owner);
    }

    @GetMapping("/")
    public ResponseEntity<List<OwnerDTO>> getAllOwners(){
        List<OwnerDTO> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO){
        OwnerDTO updatedOwner = ownerService.updateOwner(id, ownerDTO);
        return ResponseEntity.ok(updatedOwner);
    }

    @GetMapping("/{id}/cats")
    public ResponseEntity<List<CatDTO>> getOwnerCats(@PathVariable Long id){
        List<CatDTO> cats = ownerService.getCatsByOwnerId(id);
        return ResponseEntity.ok(cats);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return ResponseEntity.ok().build();
    }
}
