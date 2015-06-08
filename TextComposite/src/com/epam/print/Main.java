package com.epam.print;

import java.util.List;

import com.epam.entity.Component;
import com.epam.entity.TextParser;
import com.epam.processor.Sorter;
import com.epam.processor.Swapper;
import com.epam.report.ComponentPrinter;

public class Main {

  public static void main(String[] args) {

    String path = "Text.txt";
    TextParser textParser = new TextParser();
    Component wholeText = textParser.parse(path);

    // printing the result
    ComponentPrinter printer = new ComponentPrinter();
    printer.print("Text after parsing:");
    printer.print(wholeText);
    printer.print("----------------------------------");

    Sorter sorter = new Sorter();
    List<Component> sortedSentences = sorter.findAndSortSentencesByWordCount(wholeText);
    printer.print("Sorted sentences:");
    for (Component c : sortedSentences) {
      printer.print(c);
    }
    printer.print("----------------------------------");

    Swapper swapper = new Swapper();
    swapper.swapFirstLastWordInSentence(wholeText);
    printer.print("Text after swapping:");
    printer.print(wholeText);
    printer.print("----------------------------------");

  }
}