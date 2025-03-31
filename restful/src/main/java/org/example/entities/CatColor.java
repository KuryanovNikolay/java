package org.example.entities;

import lombok.Getter;

@Getter
public enum CatColor {
    BLACK("Черный"),
    WHITE("Белый"),
    BROWN("Коричневый"),
    ORANGE("Оранжевый"),
    GRAY("Серый");

    private final String color;

    CatColor(String color) {
        this.color = color;
    }

}
