package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {

  private ComponentType type;

  private ArrayList<Component> components = new ArrayList<Component>();

  public TextComposite(ComponentType type) {
    super();
    this.type = type;
  }

  @Override
  public void add(Component c) {
    components.add(c);
  }

  @Override
  public void addAll(List<Component> list) {
    components.addAll(list);
  }

  @Override
  public void remove(Component c) {
    components.remove(c);

  }

  @Override
  public Component getChild(int index) {
    return components.get(index);
  }

  @Override
  public ComponentType getComponentType() {
    return type;
  }

  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();
    for (Component c : components) {
      result.append(c.toString());
      if(c.getComponentType().equals(ComponentType.WORD)){
        result.append(" ");
      }
    }
    return result.toString();
  }

  @Override
  public List<Component> getChildren() {
    return components;
  }

}
