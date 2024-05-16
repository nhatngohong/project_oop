package org.example.service;

import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.CommentDB;
import org.example.database.PostDB;

public class CommentService {
    public static void create(int postId, String content) {
        if (PostDB.findById(postId) == null) {
            System.out.println("Post does not exist");
            return;
        }
        Comment comment = new Comment(content, postId, UserController.currentUser.getId());
        CommentDB.create(comment);
    }
}
