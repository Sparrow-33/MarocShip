package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Named("responsableBean")
@RequestScoped
@Getter
@Setter
public class ResponsableBean implements Serializable {
    private String email;
    private String password;

}
