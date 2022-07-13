package com.example.workstudy.data;

import com.example.workstudy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostData extends JpaRepository<Post,Long> {
}
