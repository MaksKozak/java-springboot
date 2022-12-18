package ua.com.owu.javaspringboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.javaspringboot.models.Car;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    ArrayList<Car> car = new ArrayList<>();

    public MainController() {

        car.add(new Car(1, "Fiat", "scudo", 90, 2007));
        car.add(new Car(2, "Volvo", "v50", 110, 2010));
        car.add(new Car(3, "Wv", "cc", 120, 2019));
        car.add(new Car(4, "Bmw", "mmm", 240, 2014));
        car.add(new Car(5, "Lada", "kalina", 50, 2222));
        car.add(new Car(6, "Mercedes", "gls", 180, 3722));
        car.add(new Car(7, "Opel", "mondeo", 100, 8377));
        car.add(new Car(8, "Honda", "acord", 190, 3937));
        car.add(new Car(9, "Ford", "raptor", 300, 3783));
        car.add(new Car(10, "Nissan", "GTturbo", 700, 7535));
        car.add(new Car(11, "Subaru", "minus4rututu", 500, 6832));
        car.add(new Car(12, "Audi", "q7", 340, 6727));
        car.add(new Car(13, "Akura", "manun", 70, 2767));
        car.add(new Car(14, "Infiniti", "k1turbo", 90, 8263));
        car.add(new Car(15, "Kia", "b2", 200, 8521));

    }


    @GetMapping({"/car"})
    public ResponseEntity<List<Car>> getCar() {
        return new ResponseEntity<>(
                this.car, HttpStatus.OK
        );
    }


}

