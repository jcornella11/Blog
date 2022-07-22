package com.gcu.blog.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Blogs")
public class BlogEntity {

    @Id
    private Long id;

    @Column("AUTHOR_NAME")
    private String authorName;

    @Column("TITLE")
    private String title;

    @Column("INTRODUCTION")
    private String introduction;

    @Column("BODY")
    private String body;

    @Column("CONCLUSION")
    private String conclusion;

    public BlogEntity() {
    }

    public BlogEntity(Long id, String authorName, String title, String introduction, String body, String conclusion) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.introduction = introduction;
        this.body = body;
        this.conclusion = conclusion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
