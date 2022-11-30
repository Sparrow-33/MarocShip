package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Named("managerBean")
@RequestScoped
@Getter
@Setter
public class ManagerBean implements Serializable {
    private String email;
    private String password;

}
