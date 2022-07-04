package com.example.workstudy.repo;

import com.example.workstudy.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PostDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Post savePost(Post post){
        return this.entityManager.merge(post);
    }
}
