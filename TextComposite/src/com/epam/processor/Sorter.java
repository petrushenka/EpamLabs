package com.epam.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.epam.entity.Component;
import com.epam.entity.ComponentType;

public class Sorter {
  public List<Component> findAndSortSentencesByWordCount(Component source) {
    List<Component> result = new ArrayList<Component>();
    findAndAddSentence(source, result);
    Collections.sort(result, new Comparator<Component>() {

      @Override
      public int compare(Component arg0, Component arg1) {
        return getWordCount(arg0).compareTo(getWordCount(arg1));
      }

      private Integer getWordCount(Component component) {
        Integer result = 0;
        if (component != null && component.getChildren() != null) {
          for (Component c : component.getChildren()) {
            if (ComponentType.WORD.equals(c.getComponentType())) {
              result++;
            }
          }
        }
        return result;
      }

    });
    return result;
  }

  private void findAndAddSentence(Component source, List<Component> result) {
    if (source != null) {
      if (ComponentType.SENTENCE.equals(source.getComponentType())) {
        result.add(source);
      }
      if (source.getChildren() != null) {
        for (Component c : source.getChildren()) {
          findAndAddSentence(c, result);
        }
      }
    }
  }
}
