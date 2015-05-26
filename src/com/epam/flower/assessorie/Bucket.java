package com.epam.flower.assessorie;

import com.epam.flower.BucketSize;

public class Bucket extends Accessory {

  private BucketSize size;

  public Bucket(String name, BucketSize size) {
    super(name);
    setSize(size);
  }

  public BucketSize getSize() {
    return size;
  }

  public void setSize(BucketSize size) {
    this.size = size;
  }

  @Override
  public int countPrice() {
    switch (size) {
    case Big:
      return 30_000;
    case Middle:
      return 20_000;
    case Small:
      return 10_000;
    default:
      return 5000;
    }
  }

}
