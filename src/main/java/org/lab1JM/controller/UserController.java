package org.lab1JM.controller;

import org.lab1JM.dao.UserDAO;
import org.lab1JM.model.User;

public class UserController {
    private UserDAO dao = new UserDAO();

    public boolean register(User user) {
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) return false;
        if (!user.getEmail().contains("@")) return false;

        return dao.insertUser(user);
    }

    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    public boolean updateUser(User user) {
        return dao.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return dao.deleteUser(id);
    }
}

