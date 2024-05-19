package org.example.database;

import org.example.comment.Comment;
import org.example.user.User;
import org.example.util.FileUtil;
import org.example.util.IdUtil;
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

    public static void modify(Comment comment, Comment modifiedComment) {
        FileUtil.modify("commentdb.txt", comment, modifiedComment, Comment.class);
    }

    public static void create(Comment comment) {
        comment.setId(IdUtil.generateForComment(findAll()));
        FileUtil.write(comment, "commentdb.txt");
    }

    public static void delete(Comment comment) {
        FileUtil.delete("commentdb.txt", comment, Comment.class);
    }
}
