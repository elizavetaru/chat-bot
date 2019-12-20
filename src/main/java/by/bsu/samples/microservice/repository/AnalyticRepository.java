package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnalyticRepository extends JpaRepository<Car, Long>, AnalyticRepositoryCustom {

    @Transactional
    @Modifying
    @Query(value = "SELECT distinct bot.car.link FROM bot.car left join bot.feature on bot.car.feature_id = bot.feature.id where :value", nativeQuery = true)
    List<String> askQuestion(@Param("value") String value);

}
