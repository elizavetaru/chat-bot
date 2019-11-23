package by.bsu.samples.microservice.executor;

import by.bsu.samples.microservice.parser.SiteParser;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private Integer pageNumber;
    private SiteParser parser;
    private CountDownLatch latch;

    public Task(Integer pageNumber, SiteParser parser, CountDownLatch latch) {
        this.pageNumber = pageNumber;
        this.parser = parser;
        this.latch = latch;
    }

    @Override
    public void run() {
        parser.parse(pageNumber);

        latch.countDown();
    }
}
