package com.example.workstudy.repo;

import com.example.workstudy.data.PostData;
import com.example.workstudy.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private PostData postData;

    @Autowired
    public PostDAO(PostData postData) {
        this.postData = postData;
    }

    public Post savePost(Post post) {
        return this.entityManager.merge(post);
    }

    public List fetchAllPostsWithNoComments() {
        return this.entityManager.createQuery("select distinct p from Post p " +
                        "join fetch p.user u " +
                        "left join fetch p.comments c " +
                        "where size(p.comments)=0 " +
                        "and p.deleted=false " +
                        "and u.deleted=false")
                .getResultList();
    }

    public List fetchAllPostsWithComments() {
        return this.entityManager.createQuery("select distinct p from Post p " +
                        "join fetch p.user u " +
                        "inner join fetch p.comments c " +
                        "where p.deleted=false " +
                        "and c.deleted=false " +
                        "and u.deleted=false")
                .getResultList();
    }
}
