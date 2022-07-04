package com.example.workstudy.repo;

import com.example.workstudy.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Comment saveComment(Comment comment) {
        return this.entityManager.merge(comment);
    }
}
