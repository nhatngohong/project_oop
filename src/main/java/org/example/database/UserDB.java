package org.example.database;

import org.example.user.BasicUser;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class UserDB {
    public static List<User> findAll() {
        return FileUtil.read("userdb.txt", User.class);
    }

    public static void save(User user) {
        FileUtil.add(user, "userdb.txt");
    }

    public static void modify(User user) {
        FileUtil.modify("userdb.txt", user.getId(), JsonUtil.toJson(user));
    }
}
