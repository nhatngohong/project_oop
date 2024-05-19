package org.example.service;

import com.google.gson.stream.JsonToken;
import org.example.comment.Comment;
import org.example.controller.UserController;
import org.example.database.PostDB;
import org.example.database.TagDB;
import org.example.database.UserDB;
import org.example.dto.UserCredentialDto;
import org.example.post.Post;
import org.example.post.Tag;
import org.example.user.BasicUser;
import org.example.user.ProUser;
import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static void signin(UserCredentialDto userCredential) {

        List<User> users = UserDB.findAll();

        UserController.currentUser = getUserSignIn(userCredential, users);

    }

    public static void signup(UserCredentialDto userCredential) {

        BasicUser userSignUp = getUserSignUp(userCredential);

        UserDB.create(userSignUp);

    }

    public static void update(UserCredentialDto user) {

        User updateUser;
        User currentUser = UserController.currentUser;
        if (currentUser instanceof BasicUser) {
            updateUser = new BasicUser();
        } else {
            updateUser = new ProUser();
        }
        updateUser.setId(currentUser.getId());
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());

        UserDB.modify(currentUser, updateUser);
    }

    public static void addTag(int tagId, int postId) {

        Post post = PostDB.findById(postId);
        Tag tag = TagDB.findById(tagId);

        if (post == null) {
            System.out.println("Can not find post with id: " + postId);
            return;
        }
        if (tag == null) {
            System.out.println("Can not find tag with id: " + tagId);
            return;
        }
        if (UserController.currentUser instanceof BasicUser) {
            System.out.println("You can not add tag as basic user");
            return;
        }

        Post updatedPost = new Post(post);
        List<Integer> tagIds = new ArrayList<>(updatedPost.getTags());
        tagIds.add(tagId);
        updatedPost.setTags(tagIds);

        PostDB.modify(post, updatedPost);
    }

    private static User getUserSignIn(UserCredentialDto userCredential, List<User> database) {

        String username = userCredential.getUsername();
        String password = userCredential.getPassword();

        for (User user : database) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        //TODO fix
        System.out.println("Incorrect username or password");
        return null;
    }

    private static BasicUser getUserSignUp(UserCredentialDto signUpUser) {

        return new BasicUser(
                signUpUser.getUsername(),
                signUpUser.getPassword()
        );
    }
}
