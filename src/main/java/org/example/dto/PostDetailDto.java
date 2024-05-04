package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.post.Tag;

import java.util.List;
@Data
@AllArgsConstructor
public class PostDetailDto {

    private int id;

    private int ownerId;

    private List<Tag> tags;

    private int upvote;

    private String title;

    private String content;
}
