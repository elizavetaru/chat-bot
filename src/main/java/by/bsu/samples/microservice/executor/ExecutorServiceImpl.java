package by.bsu.samples.microservice.executor;

import by.bsu.samples.microservice.parser.SiteParser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class ExecutorServiceImpl {

    private Logger logger = LoggerFactory.getLogger(ExecutorServiceImpl.class);

    @Autowired
    private SiteParser parser;

    public void startProcessing() {
        for (int i = 1; i < 40; i += 2) {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            CountDownLatch cdl1 = new CountDownLatch(1);
            CountDownLatch cdl2 = new CountDownLatch(1);

            logger.info("Старт потоков");

            executor.execute(new Task(i, parser, cdl1));
            executor.execute(new Task(i + 1, parser, cdl2));


            try {
                cdl1.await();
                cdl2.await();
            } catch (InterruptedException exc) {
            }

            executor.shutdown();
            logger.info(String.format("Завершение потоков: итерация %s", i));
        }

    }
}
