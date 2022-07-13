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
        return this.entityManager.createQuery("select p from Post p" +
                        " left join fetch p.comments c" +
                        " where p.comments.size=0" +
                        " and p.deleted=false" +
                        " and p.user.deleted=false")
                .getResultList();
    }
}
