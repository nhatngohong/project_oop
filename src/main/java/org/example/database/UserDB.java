package org.example.database;

import org.example.post.Post;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class UserDB {
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
        FileUtil.create(user, "userdb.txt");
    }

    public static void modify(User user) {
        FileUtil.modify("userdb.txt", user.getId(), JsonUtil.toJson(user));
    }
}
