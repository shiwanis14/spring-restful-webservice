package com.ownprojects.rest.webservice.restfulwebservice.Versioning;

public class Name2 {

  private FullName fullName;

  public FullName getFullName() {
    return fullName;
  }

  public void setFullName(FullName fullName) {
    this.fullName = fullName;
  }

  public Name2(FullName fullName) {
    this.fullName = fullName;
  }

  @Override
  public String toString() {
    return "Name2{" +
        "fullName=" + fullName +
        '}';
  }
}
