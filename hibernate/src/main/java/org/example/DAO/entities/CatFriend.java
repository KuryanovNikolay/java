package org.example.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cat1_id", nullable = false)
    private Cat cat1;

    @ManyToOne
    @JoinColumn(name = "cat2_id", nullable = false)
    private Cat cat2;
}
