package backend.services;

import backend.entities.User;

public class UserModel {

    public static User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        UserModel.user = user;
    }

    public void logOut() {
        user.setUsername(null);
        user.setPassword(null);
        user.setEmail(null);
        user.setCity(null);
        user.setFirstName(null);
        user.setLastName(null);
        user.setMasterCard(null);
        user.setVisa(null);
        user.setCredit(null);
    }
}
