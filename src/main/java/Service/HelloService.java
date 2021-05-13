package Service;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

@ManagedBean("helloService")
@SessionScoped
public class HelloService {
  public String convert(String input) {
    return "HELLO: " + input.toUpperCase();
  }
}