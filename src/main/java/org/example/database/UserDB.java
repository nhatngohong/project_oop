package org.example.database;

import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class UserDB {
    public static List<User> findAll() {
        String database = FileUtil.read("userdb.txt");
        return JsonUtil.toObject(database, List.class);
    }

    public static void save(List<User> database) {
        FileUtil.write(database, "userdb.txt");
    }
}
