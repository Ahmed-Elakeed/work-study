package com.example.workstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}
