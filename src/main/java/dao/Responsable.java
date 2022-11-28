package dao;

import Interfaces.User;
import entities.ResponsableENT;

public class Responsable extends Base<ResponsableENT> implements User<ResponsableENT> {
    @Override
    public ResponsableENT findByEmail(String email) {
        return null;
    }

    @Override
    public ResponsableENT signIn(String email, String password) {
        return null;
    }
}
