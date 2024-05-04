package org.example.database;

import org.example.comment.Comment;
import org.example.post.Post;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class CommentDB {
    public static List<Comment> findAll() {
        return FileUtil.read("commentdb.txt", Comment.class);
    }

    public static Comment findById(int id) {
        List<Comment> database = findAll();
        for (Comment comment : database) {
            if (comment.getId() == id) {
                return comment;
            }
        }
        return null;
    }

    public static void modify(Comment comment) {
        FileUtil.modify("commentdb.txt", comment.getId(), JsonUtil.toJson(comment));
    }

    public static void create(Comment comment) {
        FileUtil.create(comment, "commentdb.txt");
    }
}
