package com.epam.flower.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.epam.flower.plant.Bouquet;
import com.epam.flower.plant.Flower;

public class ReportWriter {

  private PrintWriter out;

  public ReportWriter(String fileName) {

    File file = new File(fileName);

    try {
      if (!file.exists()) {
        file.createNewFile();
      }

      out = new PrintWriter(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void writeln(String text) {
    out.println(text);
  }

  public void close() {
    out.close();
  }

  static void writeBouquetReport(Bouquet bouquet) {
    ReportWriter writer = new ReportWriter("log/report.txt");
    try {
      writer.writeln("Bouquet Price: " + bouquet.getBouquetPrice() + '\n'
          + "---------------------------------------------------------------------------------");
      writer.writeln("Before Sorting:");
      ReportWriter.printFlowersList(bouquet.getFlowers(), writer);
      writer
          .writeln("----------------------------------------------------------------------------");

      writer.writeln("After Sorting:");
      ReportWriter.printFlowersList(SortingService.getSortedListByFreshness(bouquet.getFlowers()),
          writer);
      writer
          .writeln("----------------------------------------------------------------------------");

      int min = 25;
      int max = 35;

      writer.writeln("List of flowers with the length from " + min + " to " + max + " :");
      ReportWriter.printFlowersList(
          FilterService.filterByLengthMinMax(bouquet.getFlowers(), min, max), writer);

    } catch (Exception e) {
      Florist.LOG.error("Some exception is caught during the processing", e);
    } finally {
      writer.close();
    }
  }

  static void printFlowersList(List<Flower> flowers, ReportWriter writer) {
    for (Flower f : flowers) {
      writer.writeln("\t " + f);
    }
  }
}
