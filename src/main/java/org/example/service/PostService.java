package org.example.service;

import org.example.database.PostDB;
import org.example.post.Post;

import java.util.List;

public class PostService {
    public static List<Post> getAll() {
        return PostDB.findAll();
    }

    public static Post getById(int id) {

        return PostDB.findById(id);
    }


}
