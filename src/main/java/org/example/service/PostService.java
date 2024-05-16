package org.example.service;

import org.example.comment.Comment;
import org.example.database.CommentDB;
import org.example.database.PostDB;
import org.example.database.TagDB;
import org.example.dto.PostDetailDto;
import org.example.dto.PostSimpleDto;
import org.example.post.Post;
import org.example.post.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class PostService {
    public static List<PostSimpleDto> getAll() {
        return PostDB.findAll()
                .stream()
                .map(Post::toSimpleDto)
                .collect(Collectors.toList());
    }

    public static PostDetailDto getById(int id) {
        Post post = PostDB.findById(id);
        if (post == null) return null;
        List<Integer> tagIds = post.getTags();
        List<Integer> commentIds = post.getComments();
        List<Tag> tags = tagIds
                .stream()
                .map(TagDB::findById)
                .toList();
        List<Comment> comments = commentIds
                .stream()
                .map(CommentDB::findById)
                .toList();
        return PostDB.findById(id).toDetailDto();
    }

    public static void create(Post newPost) {
        PostDB.create(newPost);
    }

    public static void update(Integer ID, Post updatePost) {
        Post post = PostDB.findById(ID);
        if (post == null) {
            System.out.println("ID don't exist");
            return;
        } else {
            PostDB.modify(post, updatePost);
        }
    }

    public static void delete(Integer ID) {
        Post post = PostDB.findById(ID);
        if (post == null) {
            System.out.println("ID don't exist");
            return;
        } else {
            PostDB.delete(post);
        }
    }


}
