package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.executor.ExecutorServiceImpl;
import by.bsu.samples.microservice.generic.GenericServiceImpl;
import by.bsu.samples.microservice.model.Car;
import by.bsu.samples.microservice.repository.CarRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("carService")
@Transactional
public class CarServiceImpl extends GenericServiceImpl<Car> implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ExecutorServiceImpl executorServiceImpl;

    @Override
    protected JpaRepository<Car, Long> getRepository() {
        return carRepository;
    }

    @Override
    public void searchCars() {
        executorServiceImpl.startProcessing();
    }
}
