package com.epam.entity;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser {

  static final private Logger LOG = LogManager.getLogger(TextParser.class);

  static private Properties regularExpressions = new Properties();

  public static final String PARAGRAPH_SEPARATOR = "paragraph.separator";
  public static final String SENTENCE_SEPARATOR = "sentence.separator";
  public static final String WORD_SEPARATOR = "word.separator";
  public static final String PUNCTUATIONS = "punctuations";

  static {
    try {
      regularExpressions.load(TextParser.class
          .getResourceAsStream("/com/epam/resourse/regexp.properties"));
    } catch (IOException e) {
      LOG.fatal(e);
    }
  }

  public TextParser() {
  }

  public Component parse(String path) {
    String sourceText = readFile(path);
    TextComposite textComposite = new TextComposite(ComponentType.TEXT);
    List<Component> paragraphs = splitToParagraphs(sourceText);
    textComposite.addAll(paragraphs);
    return textComposite;
  }

  private List<Component> splitToParagraphs(String sourceText) {
    List<Component> resultList = new ArrayList<Component>();
    Pattern paragraphSeparatorPattern = Pattern.compile(regularExpressions
        .getProperty(PARAGRAPH_SEPARATOR));
    for (String paragraphText : paragraphSeparatorPattern.split(sourceText)) {
      paragraphText = paragraphText + ".";
      // now we need to figure out the type of paragraph - code or text
      Component paragraph = null;
      if (paragraphText.contains("{") && paragraphText.contains("}")) {
        paragraph = new Leaf(ComponentType.CODEBLOCK, paragraphText);
      } else {
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        List<Component> sentences = splitToSentences(paragraphText);
        paragraph.addAll(sentences);
      }
      resultList.add(paragraph);
    }
    return resultList;
  }

  private List<Component> splitToSentences(String paragraphText) {
    List<Component> resultList = new ArrayList<Component>();
    Pattern sentencesSeparatorPattern = Pattern.compile(regularExpressions
        .getProperty(SENTENCE_SEPARATOR));
    for (String sentenceText : sentencesSeparatorPattern.split(paragraphText)) {
      Component sentence = new TextComposite(ComponentType.SENTENCE);
      List<Component> words = splitToWords(sentenceText);
      if (words.size() > 0) {
        words.add(new Leaf(ComponentType.PUNCTUATION, "."));
      }
      sentence.addAll(words);

      resultList.add(sentence);
    }

    return resultList;
  }

  private List<Component> splitToWords(String sentenceText) {
    List<Component> resultList = new ArrayList<Component>();
    Pattern sentencesSeparatorPattern = Pattern.compile(regularExpressions
        .getProperty(WORD_SEPARATOR));
    for (String wordText : sentencesSeparatorPattern.split(sentenceText)) {
      if (wordText != null && wordText.length() > 0) {
        Component word = new TextComposite(ComponentType.WORD);
        List<Component> literals = splitToLiterals(wordText);
        word.addAll(literals);

        resultList.add(word);
      }
    }
    return resultList;
  }

  private List<Component> splitToLiterals(String wordText) {
    List<Component> result = new ArrayList<Component>();
    for (char ch : wordText.toCharArray()) {
      // checking if literal is letter or punctuation mark and setting the type accordingly
      Pattern punctuationsPattern = Pattern.compile(regularExpressions.getProperty(PUNCTUATIONS));
      if (punctuationsPattern.matcher(ch + "").matches()) {
        result.add(new Leaf(ComponentType.PUNCTUATION, ch + ""));
      } else {
        result.add(new Leaf(ComponentType.PUNCTUATION, ch + ""));
      }
    }
    return result;
  }

  private String readFile(final String path) {
    String text = null;
    try {
      text = new String(Files.readAllBytes(FileSystems.getDefault().getPath(path)));
    } catch (IOException e) {
      LOG.error(e);
    }
    return text;
  }

}