package org.example.database;

import org.example.user.User;
import org.example.util.FileUtil;

import java.util.List;

public class UserDB {

    //TODO fix
    private static final int CURRENT_ID = 0;
    public static List<User> findAll() {
        return FileUtil.read("userdb.txt", User.class);
    }

    public static User findById(int id) {
        List<User> database = findAll();
        for (User user : database) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static void create(User user) {
        FileUtil.write(user, "userdb.txt");
    }

    public static void modify(User user, User modifiedUser) {
        FileUtil.modify("userdb.txt", user, modifiedUser, User.class);
    }

    public static void delete(User user) {
        FileUtil.delete("userdb.txt", user, User.class);
    }
}
