package com.java8.practise;

public class Item {
  private final String id;
  private final Integer qt;
  private final String name;

  public Item(final String id, final Integer qt, final String name) {
    this.id = id;
    this.qt = qt;
    this.name = name;
  }

  public String getId() {
    return this.id;
  }

  public Integer getQt() {
    return this.qt;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Item [id=" + this.id + ", qt=" + this.qt + ", name=" + this.name + "]";
  }
}
