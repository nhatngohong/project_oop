package org.example.service;

import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.CommentDB;
import org.example.database.PostDB;
import org.example.database.TagDB;
import org.example.dto.CommentSimpleDto;
import org.example.dto.PostDetailDto;
import org.example.dto.PostSimpleDto;
import org.example.post.Post;
import org.example.post.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostService {
    public static List<PostSimpleDto> getAll() {
        return PostDB.findAll()
                .stream()
                .map(Post::toSimpleDto)
                .toList();
    }

    public static PostDetailDto getById(int id) {
        Post post = PostDB.findById(id);
        if (post == null) {
            System.out.println("ID don't exist");
            return null;
        }
        List<Integer> tagIds = post.getTags();
        List<Tag> tags = tagIds
                .stream()
                .map(TagDB::findById)
                .toList();
        List<CommentSimpleDto> comments = CommentDB.findAll()
                .stream()
                .filter(comment -> Objects.equals(comment.getPostId(), post.getId()))
                .map(Comment::toSimpleDto)
                .toList();
        return post.toDetailDto(tags, comments);
    }

    public static void create(Post newPost) {
        PostDB.create(newPost);
    }

    public static void update(Integer ID, String newTitle, String newContent) {
        Post post = PostDB.findById(ID);
        if (post == null) {
            System.out.println("ID don't exist");
            return;
        }
        if (post.getOwnerId() != UserController.currentUser.getId()) {
            System.out.println("You cannot update this post");
            return;
        }
        Post newPost = new Post();
        newPost.setId(post.getId());
        newPost.setTags(post.getTags());
        newPost.setOwnerId(post.getOwnerId());
        newPost.setUpvotedIds(post.getUpvotedIds());
        newPost.setTitle(newTitle);
        newPost.setContent(newContent);
        PostDB.modify(post, newPost);

    }

    public static void delete(Integer ID) {
        Post post = PostDB.findById(ID);
        if (post == null) {
            System.out.println("ID don't exist");
            return;
        }
        if (post.getOwnerId() != UserController.currentUser.getId()) {
            System.out.println("You cannot delete this post");
            return;
        }
        PostDB.delete(post);
    }

    public static void upvote(Integer ID) {
        Post post = PostDB.findById(ID);
        if (post == null) {
            System.out.println("ID don't exist");
            return;
        }
        Post newPost = new Post();
        newPost.setId(post.getId());
        newPost.setTags(post.getTags());
        newPost.setOwnerId(post.getOwnerId());
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());


        List<Integer> upvotedIds = new ArrayList<>(post.getUpvotedIds());
        Integer userCurrentId = UserController.currentUser.getId();
        if (upvotedIds.contains(userCurrentId)) {
            upvotedIds.remove(userCurrentId);
        } else {
            upvotedIds.add(userCurrentId);
        }
        newPost.setUpvotedIds(upvotedIds);
        PostDB.modify(post, newPost);
    }
}
