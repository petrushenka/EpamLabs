package com.epam.flower.assessorie;

import java.util.ArrayList;
import java.util.List;

import com.epam.flower.BucketSize;
import com.epam.flower.Color;
import com.epam.flower.plant.GreenhouseFlower;

public class HardcodeAccessoryCreator implements AccessoryCreator {

  public List<Accessory> getAccessoryList() {

    List<Accessory> resultList = new ArrayList<Accessory>();

    resultList.add(new Bucket("Big Beautiful Bucket for lovely woman", BucketSize.Big));
    resultList.add(new Paper("Glossy Red Wine Paper", 2));
    resultList.add(new Ribbon("White Ribbon", 3));

    return resultList;
  }
}