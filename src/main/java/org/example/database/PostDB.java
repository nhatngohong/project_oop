package org.example.database;

import org.example.post.Post;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class PostDB {
    public static List<Post> findAll() {
        return FileUtil.read("postdb.txt", Post.class);
    }
}
