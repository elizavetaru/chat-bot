package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericService;
import by.bsu.samples.microservice.model.Car;

import java.util.List;
import java.util.Map;

public interface AnalyticService extends GenericService<Car> {
    List<Car> answerQuestion(Map<String, String> questionary);
}
