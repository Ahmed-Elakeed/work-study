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
        return this.entityManager.createQuery("select distinct c from Comment c " +
                        "join fetch c.user u " +
                        "join fetch c.post p " +
                        "where u.email=:userEmail" +
                        " and c.deleted=false" +
                        " and u.deleted=false" +
                        " and p.deleted=false")
                .setParameter("userEmail", userEmail)
                .getResultList();
    }

    public List fetchAllCommentsContainsWord(String word) {
        return this.commentData.allCommentsContainsWord(word);
    }
}
