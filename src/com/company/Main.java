package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      BusStop busStop = objectMapper.readValue(new File("src/data.json"), BusStop.class);
      System.out.println(busStop);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
