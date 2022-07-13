package com.example.workstudy.data;

import com.example.workstudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserData extends JpaRepository<User,Long> {
}
