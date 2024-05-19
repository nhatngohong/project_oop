package org.example.util;

import org.example.comment.Comment;
import org.example.post.Post;
import org.example.user.User;

import java.util.List;

public class IdUtil {
    public static int generateForUser(List<User> database) {
        int id = -1;
        for (User user : database) {
            id = Math.max(id, user.getId());
        }
        return id + 1;
    }
    public static int generateForPost(List<Post> database) {
        int id = -1;
        for (Post post : database) {
            id = Math.max(id, post.getId());
        }
        return id + 1;
    }
    public static int generateForComment(List<Comment> database) {
        int id = -1;
        for (Comment comment : database) {
            id = Math.max(id, comment.getId());
        }
        return id + 1;
    }
}
