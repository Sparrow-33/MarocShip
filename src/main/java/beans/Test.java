package beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("testController")
@RequestScoped
public class Test implements Serializable {
   public String moveToPage1() {
        return "page1?faces-redirect = true";
   }
}
