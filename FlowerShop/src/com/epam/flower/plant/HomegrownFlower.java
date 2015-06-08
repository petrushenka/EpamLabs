package com.epam.flower.plant;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.flower.Color;

public class HomegrownFlower extends Flower {

  private String supplierName;

  public HomegrownFlower(String name, Date cutDate, Color color, int length, int price,
      String supplierName) {
    super(name, cutDate, color, length, price);
    this.supplierName = supplierName;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }
  
  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    return "Homegrown Flower : " + getName() + " (Color=" + getColor() + ", Price=" + countPrice()
        + ", Length=" + getLength() + ", Date of cutting=" + format.format(getCutDate())
        + ", From Supplier =" + getSupplierName() + ")";
  }

}
