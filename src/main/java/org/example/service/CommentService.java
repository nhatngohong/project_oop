package org.example.service;

import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.CommentDB;
import org.example.database.PostDB;

import java.util.Objects;

public class CommentService {
    public static void create(int postId, String content) {
        if (PostDB.findById(postId) == null) {
            System.out.println("No such post");
            return;
        }
        Comment comment = new Comment(content, postId, UserController.currentUser.getId());
        CommentDB.create(comment);
    }

    public static void update(int commentId, String newContent) {
        Comment comment = CommentDB.findById(commentId);
        if (comment == null) {
            System.out.println("No such comment");
            return;
        }
        if (!Objects.equals(comment.getOwnerId(), UserController.currentUser.getId())) {
            System.out.println("You can not update this comment");
            return;
        }
        Comment updatedComment = new Comment();
        updatedComment.setId(comment.getId());
        updatedComment.setContent(newContent);

        CommentDB.modify(comment, updatedComment);
    }

    public static void delete(int commentId) {
        Comment comment = CommentDB.findById(commentId);
        if (comment == null) {
            System.out.println("No such comment");
            return;
        }
        if (!Objects.equals(comment.getOwnerId(), UserController.currentUser.getId())) {
            System.out.println("You can not delete this comment");
            return;
        }

        CommentDB.delete(comment);
    }
}
