package com.epam.flower.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.epam.flower.plant.Flower;

public class SortingService {

  public static List<Flower> getSortedListByFreshness(List<Flower> unsortedList) {

    List<Flower> resultList = new ArrayList<Flower>();
    resultList.addAll(unsortedList);

    Collections.sort(resultList, new Comparator<Flower>() {

      @Override
      public int compare(Flower flower1, Flower flower2) {

        return flower1.getCutDate().compareTo(flower2.getCutDate());
      }

    });

    return resultList;
  }
}
