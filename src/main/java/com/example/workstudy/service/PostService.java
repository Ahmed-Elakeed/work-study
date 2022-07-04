package com.example.workstudy.service;

import com.example.workstudy.entity.Post;
import com.example.workstudy.repo.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostDAO postDAO;

    @Autowired
    public PostService(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Transactional
    public Post savePost(Post post){
        return this.postDAO.savePost(post);
    }
}
