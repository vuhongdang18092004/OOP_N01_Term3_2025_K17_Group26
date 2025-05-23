package test;

import src.User;
import java.util.ArrayList;
import java.util.List;

public class ListOfUser {
    private List<User> users;

    public ListOfUser() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByIndex(int index) {
        return users.get(index);
    }
}
