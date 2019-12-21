package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.generic.GenericServiceImpl;
import by.bsu.samples.microservice.model.Car;
import by.bsu.samples.microservice.repository.AnalyticRepository;
import by.bsu.samples.microservice.repository.AnalyticRepositoryImpl;
import by.bsu.samples.microservice.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("analyticService")
@Transactional
public class AnalyticServiceImpl extends GenericServiceImpl<Car> implements AnalyticService {

    @Autowired
    private AnalyticRepository analyticRepository;

    @Autowired
    private AnalyticRepositoryImpl analyticRepositoryImpl;

    @Override
    protected JpaRepository<Car, Long> getRepository() {
        return analyticRepository;
    }

    @Override
    public List<Car> answerQuestion(Map<String, String> questionary) {

        HashMap<Integer, String> map = new HashMap<>();
//        map.put("What is the brand?", "brand");
//        map.put("What is the year?", "year");
//        map.put("What is the cost?", "cost");
//        map.put("What is the location?", "location");
//        map.put("What is the bodyType?", "bodyType");
//        map.put("What is the engine?", "engine");
//        map.put("What is the engine volume?", "engine volume");
//        map.put("What is the transmission?", "transmission");
//        map.put("What is the drive unit?", "drive unit");
//        map.put("What is the quality?", "quality");
        map.put(1, "brand");
        map.put(2, "year");
        map.put(3, "cost");
        map.put(4, "location");
        map.put(5, "bodyType");
        map.put(6, "engine");
        map.put(7, "engine volume");
        map.put(8, "transmission");
        map.put(9, "drive unit");
        map.put(10, "quality");

        HashMap<String, String> answers = new HashMap<>();

        for (Integer key : map.keySet()) {
            if(questionary.get(key) != null){
                answers.put(map.get(key), questionary.get(key));
            }
        }

        List<String> parameters = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<Car> db;
        for (Map.Entry<String,String> entry : answers.entrySet())   {
            parameters.add(entry.getKey());
            values.add(entry.getValue());
        }

        db = analyticRepositoryImpl.askQuestion(questionary);

        return db;
    }
}
