package com.epam.flower.plant;

import java.util.Collections;
import java.util.List;

import com.epam.flower.assessorie.Accessory;

public class Bouquet {

  private List<Flower> flowers;
  private List<Accessory> accessories;

  public Bouquet(List<Flower> flowers, List<Accessory> accessories) {
    this.flowers = Collections.unmodifiableList(flowers);
    this.accessories = Collections.unmodifiableList(accessories);
  }

  public int getBouquetPrice() {
    int resultPrice = 0;
    // calculate flowers price
    for (Flower flower : flowers) {
      resultPrice = resultPrice + flower.countPrice();
    }

    // add accessories price
    for (Accessory accessory : accessories) {
      resultPrice = resultPrice + accessory.countPrice();
    }
    return resultPrice;
  }
  
  public List<Flower> getFlowers() {
    return flowers;
  }

  public List<Accessory> getAccessories() {
    return accessories;
  }
}
