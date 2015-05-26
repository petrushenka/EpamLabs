package com.epam.flower.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.epam.flower.Color;
import com.epam.flower.plant.FieldFlower;
import com.epam.flower.plant.Flower;
import com.epam.flower.plant.GreenhouseFlower;
import com.epam.flower.plant.HomegrownFlower;

public class HardcodeCreator implements FlowerCreator {

  @Override
  public List<Flower> getFlowersList() {

    List<Flower> resultList = new ArrayList<Flower>();

    Calendar cutDateCalendar = Calendar.getInstance();

    cutDateCalendar.set(2015, 4, 29);
    resultList.add(new FieldFlower("Camomile", cutDateCalendar.getTime(), Color.White, 25, 2000,
        "Field near MTZ"));

    cutDateCalendar.set(2015, 4, 28);
    resultList.add(new FieldFlower("Cornflower", cutDateCalendar.getTime(), Color.Blue, 20, 4000,
        "Field near Urucha"));

    cutDateCalendar.set(2015, 4, 27);
    resultList.add(new HomegrownFlower("Rose", cutDateCalendar.getTime(), Color.Red, 25, 5000,
        "Tanya from Urucha"));

    cutDateCalendar.set(2015, 4, 24);
    resultList.add(new HomegrownFlower("Lily", cutDateCalendar.getTime(), Color.Yellow, 8, 25000,
        "Denis from Drazhnya"));

    cutDateCalendar.set(2015, 4, 30);
    resultList.add(new GreenhouseFlower("Rose", cutDateCalendar.getTime(), Color.White, 40, 30000,
        "Greenhouse N8"));

    cutDateCalendar.set(2015, 4, 29);
    resultList.add(new GreenhouseFlower("Tulip", cutDateCalendar.getTime(), Color.Red, 16, 20000,
        "Greenhouse N9"));

    return resultList;
  }

}
