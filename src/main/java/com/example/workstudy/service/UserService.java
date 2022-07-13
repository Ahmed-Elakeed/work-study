package com.example.workstudy.service;

import com.example.workstudy.repo.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List getAllUsers(){
        return this.userDAO.fetchAllUsers();
    }

    public List getAllUserWithUserWrapper(){return this.userDAO.fetchAllUsersWithUserWrapper();}
}

