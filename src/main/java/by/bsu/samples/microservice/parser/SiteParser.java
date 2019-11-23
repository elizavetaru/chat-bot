package by.bsu.samples.microservice.parser;

import by.bsu.samples.microservice.repository.CarRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SiteParser {

    @Autowired
    private CarRepository repository;

    private List<String> getCarLinks(Integer pageCount) {
        List<String> carLinks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://cars.av.by/page/".concat(pageCount.toString())).get();
            Elements links = doc.getElementsByClass("listing-item-image-in").select("a");
            links.forEach(link -> carLinks.add(link.attr("href")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carLinks;
    }

    @Transactional
    public void parse(Integer pageCount) {
        List<String> links = getCarLinks(pageCount);
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


                repository.saveCar(1, brand, carId);
                repository.saveCar(2, model, carId);
                repository.saveCar(3, price, carId);
                repository.saveCar(4, location, carId);
                repository.saveCar(5, bodyType, carId);
                repository.saveCar(6, year, carId);
                repository.saveCar(7, engine, carId);
                repository.saveCar(8, engineVolume, carId);
                repository.saveCar(9, transmission, carId);
                repository.saveCar(10, driveUnit, carId);
                repository.saveCar(11, quality, carId);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
