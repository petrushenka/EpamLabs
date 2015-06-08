package com.epam.flower.assessorie;

public class Ribbon extends Accessory {

  private static final int BASE_PRICE = 10_000;
  private int length;

  public Ribbon(String name, int length) {
    super(name);
    this.length = length;
  }

  @Override
  public int countPrice() {
    return length * BASE_PRICE;
  }
}
