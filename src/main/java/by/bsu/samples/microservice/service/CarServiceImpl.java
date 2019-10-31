package by.bsu.samples.microservice.service;

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
    static final Integer PAGE_COUNT = 10;

    @Autowired
    private CarRepository carRepository;

    @Override
    protected JpaRepository<Car, Long> getRepository() {
        return carRepository;
    }

    protected CarRepository getCarRepositoryRepository() {
        return carRepository;
    }

    private List<String> getCarLinks() {
        List<String> carLinks = new ArrayList<>();
        for (Integer i = 1; i < PAGE_COUNT; i++) {
            try {
                Document doc = Jsoup.connect("https://cars.av.by/page/".concat(i.toString())).get();
                Elements links = doc.getElementsByClass("listing-item-image-in").select("a");
                links.forEach(link -> carLinks.add(link.attr("href")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return carLinks;
    }

    @Override
    public void searchCars() {
        List<String> links = getCarLinks();
        for (String link : links) {
            try {
                Document doc = Jsoup.connect(link).get();
                String[] l = link.split("/");
                String carId = link;
                String brand = l[3];
                String model = l[4];
                String price = doc.getElementsByClass("card-price-main-primary").text();
                String location = doc.getElementsByClass("card-contacts-city").text();

                Elements cardInfoElelments = doc.getElementsByClass("card-info");
                String bodyType = cardInfoElelments.select("dt:contains(Тип кузова) + dd").text();
                String year = cardInfoElelments.select("dt:contains(Год выпуска) + dd").text();
                String engine = cardInfoElelments.select("dt:contains(Тип топлива) + dd").text();
                String engineVolume = cardInfoElelments.select("dt:contains(Объем) + dd").text();
                String transmission = cardInfoElelments.select("dt:contains(Трансмиссия) + dd").text();
                String driveUnit = cardInfoElelments.select("dt:contains(Привод) + dd").text();
                String quality = cardInfoElelments.select("dt:contains(Состояние) + dd").text();

                getCarRepositoryRepository().saveCar(1, brand, carId);
                getCarRepositoryRepository().saveCar(2, model, carId);
                getCarRepositoryRepository().saveCar(3, price, carId);
                getCarRepositoryRepository().saveCar(4, location, carId);
                getCarRepositoryRepository().saveCar(5, bodyType, carId);
                getCarRepositoryRepository().saveCar(6, year, carId);
                getCarRepositoryRepository().saveCar(7, engine, carId);
                getCarRepositoryRepository().saveCar(8, engineVolume, carId);
                getCarRepositoryRepository().saveCar(9, transmission, carId);
                getCarRepositoryRepository().saveCar(10, driveUnit, carId);
                getCarRepositoryRepository().saveCar(11, quality, carId);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
