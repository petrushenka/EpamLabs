package com.epam.flower.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.flower.assessorie.Accessory;
import com.epam.flower.assessorie.AccessoryCreatorFactory;
import com.epam.flower.plant.Bouquet;
import com.epam.flower.plant.Flower;

public class Florist {

  static final Logger LOG = LogManager.getLogger(Florist.class);

  public static void main(String[] args) {

    List<Flower> flowers = FlowerCreatorFactory.getFlowerCreator().getFlowersList();
    List<Accessory> accessories = AccessoryCreatorFactory.getAccessoryCreator().getAccessoryList();

    Bouquet bouquet = new Bouquet(flowers, accessories);

    ReportWriter.writeBouquetReport(bouquet);
  }
}
