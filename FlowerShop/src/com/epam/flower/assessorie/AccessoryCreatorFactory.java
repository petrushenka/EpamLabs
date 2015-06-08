package com.epam.flower.assessorie;

public class AccessoryCreatorFactory {

  public static AccessoryCreator getAccessoryCreator() {

    return new HardcodeAccessoryCreator();
  }
}
