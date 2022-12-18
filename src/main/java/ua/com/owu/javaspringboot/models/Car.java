package ua.com.owu.javaspringboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String brand;
    private String model;
    private int power;
    private int year;

}
