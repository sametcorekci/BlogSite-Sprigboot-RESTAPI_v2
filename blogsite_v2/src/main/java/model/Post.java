package model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String content;
    private String email;
    @Column(name="begeniler",nullable=false)
    private int likeCount = 0;



    public Post() {
    }

    public Post(Long id, String name, String surname, String content, String email,int likeCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.content = content;
        this.email = email;
        this.likeCount = likeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }
    public void like() {
        this.likeCount++;
    }

    public void unLike() {
        if (this.likeCount > 0) {
            this.likeCount--;
        }
    }

}