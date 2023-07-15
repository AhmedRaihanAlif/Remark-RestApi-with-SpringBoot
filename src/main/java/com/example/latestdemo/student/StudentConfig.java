package com.example.latestdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args -> {
            Student ahmedRaihanAlif=  new Student("Ahmed Raihan Alif","alif@gmail.com", LocalDate.of(2000, AUGUST,25),25);
            Student asifRaihan=  new Student("Asif Raihan  ","asif@gmail.com", LocalDate.of(1998, AUGUST,25),25);

            repository.saveAll(
                    List.of(ahmedRaihanAlif, asifRaihan)
            );
        };
    }
}
