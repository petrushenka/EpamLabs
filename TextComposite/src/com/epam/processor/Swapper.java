package com.epam.processor;

import java.util.List;

import com.epam.entity.Component;
import com.epam.entity.ComponentType;

public class Swapper {

  public void swapFirstLastWordInSentence(Component source) {
    if (source != null) {
      if (source.getComponentType().equals(ComponentType.SENTENCE)) {
        if (source.getChildren().size() > 1) {
          Integer firstWord = findFirstWord(source.getChildren());
          Integer lastWord = findLastWord(source.getChildren());
          source.getChildren().add(lastWord, source.getChildren().remove(firstWord.intValue()));
          source.getChildren().add(firstWord, source.getChildren().remove(lastWord - 1));
        }
      } else {
        for (Component child : source.getChildren()) {
          swapFirstLastWordInSentence(child);
        }
      }
    }
  }

  private Integer findLastWord(List<Component> children) {
    Integer result = null;
    int i = 0;
    for (Component c : children) {
      if (c.getComponentType().equals(ComponentType.WORD)) {
        result = i;
      }
      i++;
    }
    return result;
  }

  private Integer findFirstWord(List<Component> children) {
    Integer result = null;
    int i = 0;
    for (Component c : children) {
      if (c.getComponentType().equals(ComponentType.WORD)) {
        return i;
      }
      i++;
    }
    return result;
  }
}
