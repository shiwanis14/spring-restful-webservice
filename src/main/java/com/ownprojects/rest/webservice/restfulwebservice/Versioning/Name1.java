package com.ownprojects.rest.webservice.restfulwebservice.Versioning;

public class Name1 {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Name1{" +
        "name='" + name + '\'' +
        '}';
  }

  public Name1(String name) {
    this.name = name;
  }
}
