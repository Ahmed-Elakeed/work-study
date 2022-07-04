package com.example.workstudy.service;

import com.example.workstudy.entity.Comment;
import com.example.workstudy.repo.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    private final CommentDAO commentDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Transactional
    public Comment saveComment(Comment comment){
        return this.commentDAO.saveComment(comment);
    }
}
