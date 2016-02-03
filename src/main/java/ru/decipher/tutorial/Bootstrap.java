package ru.decipher.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.decipher.tutorial.bean.BusinessDocument;
import ru.decipher.tutorial.service.ElasticSearchService;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

/**
 * Boots up the app.
 */
@SpringBootApplication
@EnableScheduling
public class Bootstrap {

    @Autowired
    private ElasticSearchService service;

    private static final int DOCUMENTS_TO_FEED = 100;
    private static final Random RANDOM = new Random();

    /**
     * Feeds up ElasticSearch once per minute with 100 documents
     */
    @Scheduled(cron = "0 * * * * *")
    void feedElasticSearch() {
        service.index(
                IntStream.range(0, DOCUMENTS_TO_FEED).boxed().map(
                        i -> {
                            String id = UUID.randomUUID().toString();
                            return new BusinessDocument(
                                    id,
                                    String.format("Another yet document with id %s", id),
                                    String.format("http://businessdocuments.com/id=%s", id),
                                    new Date(),
                                    RANDOM.nextInt(i + 1)
                            );
                        }
                ).collect(toSet())
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(
                Bootstrap.class,
                args
        );
    }
}
