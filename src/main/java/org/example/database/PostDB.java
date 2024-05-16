package org.example.database;

import org.example.post.Post;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class PostDB {
    public static List<Post> findAll() {
        return FileUtil.read("postdb.txt", Post.class);
    }

    public static Post findById(int id) {
        List<Post> database = findAll();
        for (Post post : database) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public static void modify(Post post, Post modifiedPost) {
        FileUtil.modify("postdb.txt", post, modifiedPost, Post.class);
    }

    public static void create(Post post) {
        FileUtil.write(post, "postdb.txt");
    }
    public static void delete(Post post){
        FileUtil.delete("postdb.txt", post, Post.class);
    }

}
