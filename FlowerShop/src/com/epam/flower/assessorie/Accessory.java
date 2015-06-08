package com.epam.flower.assessorie;

import com.epam.flower.exception.IllegalFlowerException;

public abstract class Accessory {

  private int price;
  private String name;

  public Accessory(String name) {
    super();
    this.name = name;
  }

  public Accessory(int price, String name) {
    super();
    this.price = price;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int countPrice() {
    return price;
  }

  public void setPrice(int price) {
    if (price > 0) {
      this.price = price;
    } else {
      throw new IllegalFlowerException("Price can't be less or equals to zero");
    }
  }

  public void setName(String name) {
    if (name != null) {
      this.name = name;
    }
    else
    {
      throw new IllegalFlowerException("Price can't be less or equals to zero");
    }
  }
 }
