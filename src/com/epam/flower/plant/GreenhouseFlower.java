package com.epam.flower.plant;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.flower.Color;

public class GreenhouseFlower extends Flower {

  private String greenhouseNumber;

  public GreenhouseFlower(String name, Date cutDate, Color color, int length, int price,
      String greenhouseNumber) {
    super(name, cutDate, color, length, price);
    this.greenhouseNumber = greenhouseNumber;
  }

  public String getGreenhouseNumber() {
    return greenhouseNumber;
  }

  public void setGreenhouseNumber(String greenhouseNumber) {
    this.greenhouseNumber = greenhouseNumber;
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    return "Greenhouse Flower : " + getName() + " (Color=" + getColor() + ", Price=" + countPrice()
        + ", Length=" + getLength() + ", Date of cutting=" + format.format(getCutDate())
        + ", From Greenhouse=" + getGreenhouseNumber() + ")";
  }

}
