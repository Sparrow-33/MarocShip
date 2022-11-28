package beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named("testController")
@RequestScoped
@Getter
@Setter
public class Test implements Serializable {
    private String email;
    private String password;
   public String moveToPage1() {
       System.out.println("HEEERE");
       System.out.println("You submitted "+email+" "+password);
        return "page1";
   }
}
