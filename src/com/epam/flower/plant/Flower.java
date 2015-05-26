package com.epam.flower.plant;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.flower.Color;
import com.epam.flower.exception.IllegalFlowerException;

public abstract class Flower {

  private Date cutDate;
  private String name;
  private Color color;
  private int length;
  private int price;

  public Flower(String name, Date cutDate, Color color, int length, int price) {
    setCutDate(cutDate);
    setColor(color);
    setLength(length);
    setName(name);
    setPrice(price);
  }

  public int countPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getLength() {
    return length;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public Date getCutDate() {
    return cutDate;
  }

  public void setName(String name) {
    if (name != null && !name.isEmpty()) {
      this.name = name;
    } else {
      throw new IllegalFlowerException("Name of flower can't be empty!");
    }
  }

  public void setColor(Color color) {
    if (color != null) {
      this.color = color;
    } else {
      throw new IllegalFlowerException("Color of flower can't be empty!");
    }
  }

  public void setCutDate(Date cutDate) {
    if (cutDate == null) {
      throw new IllegalFlowerException("Date can't be null!");
    }
    this.cutDate = cutDate;
  }

  public void setLength(int length) {
    if (length >= 0) {
      this.length = length;
    }
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    return getName() + " (Color=" + getColor() + ", Price=" + countPrice() + ", Length="
        + getLength() + ", Date of cutting=" + format.format(getCutDate()) + ")";
  }
}
