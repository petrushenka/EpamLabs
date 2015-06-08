package com.epam.entity;

import java.util.List;

public interface Component {
  
  void add(Component c);
  
  void addAll(List<Component> list);

  void remove(Component c);
  
  List<Component> getChildren();

  Component getChild(int index);
  
  ComponentType getComponentType();
  
  }