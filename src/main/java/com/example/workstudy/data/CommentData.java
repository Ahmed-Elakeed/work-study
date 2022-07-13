package com.example.workstudy.data;

import com.example.workstudy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentData extends JpaRepository<Comment,Long> {
}
