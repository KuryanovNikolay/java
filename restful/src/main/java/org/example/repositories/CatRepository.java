package org.example.repositories;


import org.example.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> findByColor(String color);
    List<Cat> findByName(String name);
    List<Cat> findByBirthDate(Date birthDate);
}