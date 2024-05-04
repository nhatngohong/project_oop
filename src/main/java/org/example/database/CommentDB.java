package org.example.database;

import org.example.comment.Comment;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;

import java.util.List;

public class CommentDB {
    public static List<Comment> findAll() {
        return FileUtil.read("commentdb.txt", Comment.class);
    }
}
