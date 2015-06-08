package com.epam.flower.assessorie;

public class Paper extends Accessory {

  private static final int BASE_PAPER_PRICE = 10_000;
  private int size;

  public Paper(String name, int size) {
    super(name);
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  @Override
  public int countPrice() {
    return size * BASE_PAPER_PRICE;
  }
}
