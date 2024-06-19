package com.js0507dev.toy1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Toy1Application {

  public static void main(String[] args) {
    SpringApplication.run(Toy1Application.class, args);
  }

}
