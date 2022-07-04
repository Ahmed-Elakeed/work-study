package com.example.workstudy.repo;

import com.example.workstudy.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public List fetchAllUsers(){
        return this.entityManager.createQuery("select distinct u from User u left join fetch u.posts p left join fetch p.comments").getResultList();
    }
}
