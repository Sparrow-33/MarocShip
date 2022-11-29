package Interfaces;

public interface User<T> {

    T findByEmail(String email);
    T signIn(String email, String password);
}
