package org.example.service;

import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.CommentDB;
import org.example.database.PostDB;
import org.example.database.UserDB;
import org.example.post.Post;
import org.example.user.BasicUser;
import org.example.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommentService {
    public static void create(int postId, String content) {
        Post post = PostDB.findById(postId);
        if (post == null) {
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
        Comment newComment = new Comment(comment);
        newComment.setContent(newContent);
        CommentDB.modify(comment, newComment);
    }

    public static void upvote(int commentId) {
        Comment oldComment = CommentDB.findById(commentId);
        User currentUser = UserController.currentUser;
        if (oldComment == null) {
            System.out.println("No such comment");
            return;
        }
        Comment newComment = new Comment(oldComment);
        List<Integer> upvotedIds = new ArrayList<>(oldComment.getUpvotedIds());
        if (upvotedIds.contains(currentUser.getId())) {
            upvotedIds.remove(currentUser.getId());
            User user = UserDB.findById(newComment.getOwnerId());
            user.increaseReputation(currentUser instanceof BasicUser ? -1 : -2);
        } else {
            upvotedIds.add(UserController.currentUser.getId());
            User user = UserDB.findById(newComment.getOwnerId());
            user.increaseReputation(currentUser instanceof BasicUser ? 1 : 2);
        }
        CommentDB.modify(oldComment, newComment);
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
