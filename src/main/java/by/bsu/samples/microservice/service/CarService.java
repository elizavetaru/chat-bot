package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericService;
import by.bsu.samples.microservice.model.Car;
import org.springframework.stereotype.Component;

@Component
public interface CarService extends GenericService<Car> {
    void searchCars();
}
