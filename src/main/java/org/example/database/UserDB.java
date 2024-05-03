package org.example.database;

import org.example.user.User;
import org.example.util.FileUtil;

import java.util.List;

public class UserDB {
    public static List<User> findAll() {
        return FileUtil.read("userdb.txt", User.class);
    }
}
