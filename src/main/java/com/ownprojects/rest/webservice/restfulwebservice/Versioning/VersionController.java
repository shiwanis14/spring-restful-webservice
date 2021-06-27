package com.ownprojects.rest.webservice.restfulwebservice.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class VersionController {


  @GetMapping(path = "version/v1")
  public Name1 printv1() {
    return new Name1("Shiwani");
  }

  @GetMapping(path = "version/v2")
  public Name2 printv2() {
    return new Name2(new FullName("Shiwani", "Singh"));
  }

  @GetMapping(path = "/path", params = "version=1")
  public Name1 printv1person() {
    return new Name1("Shiwani");
  }

  @GetMapping(path = "/path", params = "version=2")
  public Name2 printv2person() {
    return new Name2(new FullName("Shiwani", "Singh"));
  }

  @GetMapping(path = "/header", headers = "X-API-VERSION=1")
  public Name1 printv1Header() {
    return new Name1("Shiwani");
  }

  @GetMapping(path = "/header", headers = "X-API-VERSION=2")
  public Name2 printv2Header() {
    return new Name2(new FullName("Shiwani", "Singh"));
  }
}
