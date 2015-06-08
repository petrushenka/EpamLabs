package com.epam.entity;

import java.util.Collections;
import java.util.List;

import com.epam.exception.IllegalOperationException;

public class Leaf implements Component {

  private String value;
  private ComponentType type;

  public Leaf(ComponentType type, String value) {
    super();
    this.value = value;
    this.type = type;
  }

  @Override
  public void add(Component c) {
    throw new IllegalOperationException("Unable to add child of leaf");
  }

  @Override
  public void addAll(List<Component> list) {
    throw new IllegalOperationException("Unable to add children of leaf");
  }

  @Override
  public void remove(Component c) {
    throw new IllegalOperationException("Unable to remove child of leaf");
  }

  @Override
  public List<Component> getChildren() {
    return Collections.emptyList();
  }

  @Override
  public Component getChild(int index) {
    return null;
  }

  @Override
  public ComponentType getComponentType() {
    return type;
  }

  @Override
  public String toString() {
    return value;
  }

}
