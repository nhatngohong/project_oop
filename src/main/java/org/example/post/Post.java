package org.example.post;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.comment.Comment;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int id;

    private String title;

    private String content;

    private List<Integer> tags;

    private List<Integer> comments;
}
