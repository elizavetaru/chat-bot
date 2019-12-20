package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Car;
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
        List<Predicate> predicates = new ArrayList<>();

        for (String key : questionary.keySet()) {
            predicates.add(cb.equal(car.get("featureId"), key));
            predicates.add(cb.equal(car.get("value"), questionary.get(key)));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
