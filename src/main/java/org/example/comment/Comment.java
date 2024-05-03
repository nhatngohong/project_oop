package org.example.comment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private int id;

    private String content;

    private int postId;

    private int userId;

    private int upvote;
}
