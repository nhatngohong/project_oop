package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentSimpleDto {

    private int id;

    private int ownerId;

    private int upvote;

    private String content;
}
