package com.rajeevn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner
{
    private static Logger LOGGER = LoggerFactory.getLogger(SpringBootConsoleApplication.class);

    @Override
    public void run(String... args) throws Exception
    {
        LOGGER.info("Application running...");
        LOGGER.info("Application stopping...");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }
}
