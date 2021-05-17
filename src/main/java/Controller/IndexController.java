/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import Service.HelloService;
import Service.HelloService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

//@ManagedBean(value ="helloBean")
//@RequestScoped
@ManagedBean(name="index")
@RequestScoped
public class IndexController {
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