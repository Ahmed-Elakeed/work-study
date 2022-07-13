package com.example.workstudy.repo;

import com.example.workstudy.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private UserData userData;

    @Autowired
    public UserDAO(UserData userData) {
        this.userData = userData;
    }


    public List fetchAllUsers() {
        return this.entityManager.createQuery("select distinct u from User u" +
                        " left join fetch u.posts p" +
                        " left join fetch p.comments c" +
                        " where u.deleted=false" +
                        " and p.deleted=false" +
                        " and c.deleted=false")
                .getResultList();
    }
}
