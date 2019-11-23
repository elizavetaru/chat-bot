package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.model.Car;
import by.bsu.samples.microservice.service.CarService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Timed
@RestController
@RequestMapping("/api/v1/cars")
public class CarController extends GenericController<Car> {

    private Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @Autowired
    public CarController(CarService service) {
        super(service);
    }

    @Async
    @GetMapping(value = "/items")
    public void getCarItems() {
        logger.info("Cтарт парсинга");
        carService.searchCars();
    }
}
