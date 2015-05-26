package com.epam.flower.service;

public class FlowerCreatorFactory {

  /**
   * Factory method to return instance of FlowerCreator interface
   * @return FlowerCreator instance
   */
  public static FlowerCreator getFlowerCreator() {
    return new HardcodeCreator();
    // return new ConsoleCreator();
    // return new FileCreator();
    // return new DatabaseCreator();
  }

}
