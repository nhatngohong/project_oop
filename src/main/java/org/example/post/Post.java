package org.example.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.database.PostDB;

import java.util.ArrayList;
import java.util.List;
import java.lang.Cloneable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Cloneable{

    private Integer id;

    private String title;

    private String content;

    private Integer ownerId;

    private List<Integer> tags;

    private List<Integer> comments;

    private List<Integer> upvotedIds;

    public Post(String title, String content, int userId) {

        this.id = PostDB.findAll().size();
        this.title = title;
        this.content = content;
        this.ownerId = userId;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.upvotedIds = new ArrayList<>();
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
