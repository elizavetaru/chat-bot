package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.generic.GenericController;
import by.bsu.samples.microservice.generic.GenericService;
import by.bsu.samples.microservice.model.Car;
import by.bsu.samples.microservice.repository.AnalyticRepository;
import by.bsu.samples.microservice.service.AnalyticService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Timed
@RestController
@RequestMapping("/api/v1/question")
public class AnalyticController extends GenericController<Car> {

    @Autowired
    private AnalyticService analyticService;

    @Autowired
    public AnalyticController(CarService service) {
        super(service);
    }

    @Async
    @GetMapping(value = "/items")
    public void answer() {
        Map<String, String> questionary =  new HashMap<>();
        questionary.put("6", "2000");
        questionary.put("1", "volvo");

        analyticService.answerQuestion(questionary);
    }
}
