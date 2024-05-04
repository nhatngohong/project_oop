package org.example.comment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.database.CommentDB;

@Data
@NoArgsConstructor
public class Comment {

    private int id;

    private String content;

    private int postId;

    private int ownerId;

    private int upvote;

    public Comment(String content, int postId, int userId) {
        this.id = CommentDB.findAll().size();
        this.content = content;
        this.postId = postId;
        this.ownerId = userId;
        this.upvote = 0;
    }
}
