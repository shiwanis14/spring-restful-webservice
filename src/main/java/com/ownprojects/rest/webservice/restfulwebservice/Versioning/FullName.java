package com.ownprojects.rest.webservice.restfulwebservice.Versioning;

public class FullName {

  private String firstname;
  private String lastname;


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public FullName(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

}
