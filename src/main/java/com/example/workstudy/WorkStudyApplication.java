package com.example.workstudy;

import com.example.workstudy.service.CommentService;
import com.example.workstudy.service.PostService;
import com.example.workstudy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkStudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WorkStudyApplication.class, args);
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(WorkStudyApplication.class.getName());


    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public WorkStudyApplication(UserService userService, PostService postService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @Override
    public void run(String... args) {
        LOGGER.info("All users -> {}", this.userService.getAllUsers());
        LOGGER.info("All posts with no comments -> {}", this.postService.getAllPostsWithNoComments());
        String userEmail = "ahmedelakeed@gmailcom";
        LOGGER.info("All comments with user email {} -> {}", userEmail, this.commentService.getAllCommentsWithUserEmail(userEmail));
        LOGGER.info("All posts with comments -> {}", this.postService.getAllPostsWithComments());
        LOGGER.info("All users wrappers-> {}", this.userService.getAllUserWithUserWrapper());
        String word="bro";
        LOGGER.info("All comments containing '{}' -> {}",word,this.commentService.getAllCommentsContainsWord(word));
    }
}
