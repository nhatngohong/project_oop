package org.example.comment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.database.CommentDB;
import org.example.dto.CommentSimpleDto;
import org.example.post.Post;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Comment {

    private Integer id;

    private String content;

    private Integer postId;

    private Integer ownerId;

    private List<Integer> upvotedIds;

    public Comment(String content, int postId, int userId) {
        this.id = CommentDB.findAll().size();
        this.content = content;
        this.postId = postId;
        this.ownerId = userId;
        this.upvotedIds = new ArrayList<>();
    }

    public Comment(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.postId = comment.getPostId();
        this.ownerId = comment.getOwnerId();
        this.upvotedIds = comment.getUpvotedIds();
    }

    public CommentSimpleDto toSimpleDto() {
        return new CommentSimpleDto(
                this.id,
                this.ownerId,
                this.upvotedIds.size(),
                this.content
        );
    }
}
