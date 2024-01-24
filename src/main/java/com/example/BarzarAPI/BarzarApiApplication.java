package com.example.BarzarAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.EntityManager;

@EntityScan("com.example.BarzarAPI.models")

@SpringBootApplication
public class BarzarApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(BarzarApiApplication.class, args);
  }

}
