package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Transactional
    @Modifying //is necessary as INSERT is not a part of the JPA interface
    @Query(value = "insert into car (feature_id, value, link) values (:featureId, :value, :link)", nativeQuery = true)
    void saveCar(@Param("featureId") Integer featureId, @Param("value") String value, @Param("link") String link);

}
