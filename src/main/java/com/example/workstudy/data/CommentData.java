package com.example.workstudy.data;

import com.example.workstudy.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentData extends JpaRepository<Comment,Long> {

    @Query(value = "select distinct c from Comment c join fetch c.user u join fetch c.post p where c.deleted=false and p.deleted=false and u.deleted=false and c.text like %:word%")
    List<Comment> allCommentsContainsWord(@Param(value = "word") String word);
}
