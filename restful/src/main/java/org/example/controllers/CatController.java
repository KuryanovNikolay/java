package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.services.CatDTO;
import org.example.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cats")
@AllArgsConstructor
public class CatController {
    @Autowired
    private final CatService catService;

    @PostMapping
    public ResponseEntity<CatDTO> createCat(@RequestBody CatDTO catDTO){
        CatDTO savedCat = catService.saveCat(catDTO);
        return ResponseEntity.ok(savedCat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatDTO> getCatById(@PathVariable Long id){
        CatDTO cat = catService.getCatById(id);
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/")
    public ResponseEntity<List<CatDTO>> getAllCats(){
        List<CatDTO> cats = catService.getAllCats();
        return ResponseEntity.ok(cats);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatDTO> updateCat(@PathVariable Long id, @RequestBody CatDTO catDTO){
        CatDTO updatedCat = catService.updateCat(id, catDTO);
        return ResponseEntity.ok(updatedCat);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<CatDTO>> getCatsByColor(@PathVariable String color){
        List<CatDTO> cats = catService.getCatsByColor(color);
        return ResponseEntity.ok(cats);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CatDTO>> getCatsByName(@PathVariable String name){
        List<CatDTO> cats = catService.getCatsByName(name);
        return ResponseEntity.ok(cats);
    }

    @GetMapping("/birthdate/{birthdate}")
    public ResponseEntity<List<CatDTO>> getCatsByBirthDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date birthdate){
        List<CatDTO> cats = catService.getCatsByBirthDate(birthdate);
        return ResponseEntity.ok(cats);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id){
        catService.deleteCat(id);
        return ResponseEntity.ok().build();
    }
}
