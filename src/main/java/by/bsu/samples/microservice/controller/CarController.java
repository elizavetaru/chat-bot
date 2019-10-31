package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.model.Car;
import by.bsu.samples.microservice.service.CarService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Timed
@RestController
@RequestMapping("/api/v1/cars")
public class CarController extends GenericController<Car> {

    @Autowired
    private CarService carService;

    @Autowired
    public CarController(CarService service) {
        super(service);
    }

    @GetMapping(value = "/items")
    public void getCarItems() {
        carService.searchCars();
    }
}
