/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.HelloService;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

@ManagedBean
@SessionScoped
public class HelloBean {
  @ManagedProperty(value = "#{helloService}")
  HelloService helloService;
  private String name;
  public String sayHello() {
    this.name = helloService.convert(this.name);
    return "hello";
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public HelloService getHelloService() {
    return helloService;
  }
  public void setHelloService(HelloService helloService) {
    this.helloService = helloService;
  }
}