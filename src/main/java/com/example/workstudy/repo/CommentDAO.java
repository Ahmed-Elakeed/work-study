package com.example.workstudy.repo;

import com.example.workstudy.data.CommentData;
import com.example.workstudy.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private CommentData commentData;

    @Autowired
    public CommentDAO(CommentData commentData) {
        this.commentData = commentData;
    }

    public Comment saveComment(Comment comment) {
        return this.entityManager.merge(comment);
    }

    public List fetchAllCommentsWithUserEmail(String userEmail) {
        return this.entityManager.createQuery("select c from Comment c" +
                        " where c.user.email=:userEmail" +
                        " and c.deleted=false" +
                        " and c.user.deleted=false" +
                        " and c.post.deleted=false")
                .setParameter("userEmail", userEmail)
                .getResultList();
    }
}
