package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Car;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AnalyticRepositoryImpl implements AnalyticRepositoryCustom {

    EntityManager entityManager;

    public AnalyticRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> askQuestion(Map<String, String> questionary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> cq = cb.createQuery(Car.class);

        Root<Car> car = cq.from(Car.class);
        List<List<Car>> resultSet = new ArrayList<>();

        cq.select(car.get("link"));

        for (String key : questionary.keySet()) {
            Predicate predicateForFeature = cb.equal(car.get("featureId"), key);
            Predicate predicateForValue = cb.equal(car.get("value"), questionary.get(key));
            Predicate predicateForColor = cb.and(predicateForFeature, predicateForValue);

            cq.where(predicateForColor);
            resultSet.add(entityManager.createQuery(cq).getResultList());
        }

        List<Car> result = resultSet.get(0);

        for (int i = 1; i < resultSet.size(); i++) {
            result = (List<Car>) CollectionUtils.intersection(result, resultSet.get(i));
        }

        return result;
    }
}
