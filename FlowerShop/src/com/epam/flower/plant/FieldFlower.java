package com.epam.flower.plant;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.flower.Color;

public class FieldFlower extends Flower {

  private String field;

  public FieldFlower(String name, Date cutDate, Color color, int length, int price, String field) {
    super(name, cutDate, color, length, price);
    this.field = field;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    return "Field Flower : " + getName() + " (Color=" + getColor() + ", Price=" + countPrice()
        + ", Length=" + getLength() + ", Date of cutting=" + format.format(getCutDate())
        + ", From Field=" + getField() + ")";
  }

}
