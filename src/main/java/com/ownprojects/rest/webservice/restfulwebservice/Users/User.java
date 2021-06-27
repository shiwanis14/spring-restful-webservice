package com.ownprojects.rest.webservice.restfulwebservice.Users;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  @Size(min = 5, message = "Name should be atleast 5 chars")
  private String name;
  @Past
  private Date dob;

  @OneToMany(mappedBy = "user")
  private List<Post> posts;

  public User(String name, Date dob) {
    super();
    this.id = id;
    this.name = name;
    this.dob = dob;
  }

  protected User() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  @Override
  public String toString() {
    return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, dob);
  }

}
