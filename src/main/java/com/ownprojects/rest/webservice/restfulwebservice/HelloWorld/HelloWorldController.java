package com.ownprojects.rest.webservice.restfulwebservice.HelloWorld;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping(path = "hello")
  public String printHelloWorld() {
    return "Hey!";
  }

  @GetMapping(path = "helloBean")
  public HelloBean printHelloWorldBean() {
    return new HelloBean("hey from bean");
  }

  @GetMapping(path = "helloBean/{name}")
  public HelloBean printHelloWorldBeanWithPathParam(@PathVariable String name) {
    return new HelloBean("hey from " + name);
  }

  @GetMapping(path = "helloInternational")
  public String printHelloWorldBeanWithPInternationalization(
      @RequestHeader(name = "Accept-language", required = false)Locale locale) { //accept a locale
    return messageSource.getMessage("good.morning.message", null, "DEFAULT MESSAGE", locale);
  }

  @GetMapping(path = "helloInternational2")
  public String printHelloWorldBeanWithPInternationalization2(){
    return messageSource.getMessage("good.morning.message", null, "DEFAULT MESSAGE", LocaleContextHolder.getLocale());
  }

}
