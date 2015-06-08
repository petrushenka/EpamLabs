package com.epam.flower.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.flower.plant.Flower;

public class FilterService {

  public static List<Flower> filterByLengthMinMax(List<Flower> sourceList, int min, int max) {

    List<Flower> resultList = new ArrayList<Flower>();

    for (Flower flower : sourceList) {

      if (flower.getLength() >= min && flower.getLength() <= max) {

        resultList.add(flower);
      }

    }
    return resultList;
  }

}
