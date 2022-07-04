package com.example.workstudy;

import com.example.workstudy.entity.Comment;
import com.example.workstudy.entity.Post;
import com.example.workstudy.entity.User;
import com.example.workstudy.service.CommentService;
import com.example.workstudy.service.PostService;
import com.example.workstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class WorkStudyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WorkStudyApplication.class, args);
    }


    private final UserService userService;

    @Autowired
    public WorkStudyApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.userService.getAllUsers());
    }
}
