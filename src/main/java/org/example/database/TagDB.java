package org.example.database;

import org.example.post.Tag;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class TagDB {
    public static List<Tag> findAll() {
        return FileUtil.read("tagdb.txt", Tag.class);
    }
}
