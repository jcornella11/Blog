package com.gcu.blog.models;

import javax.validation.constraints.Size;
import java.sql.Date;

public class BlogModel {

    private long id;
    private String authorName;

    private String title;

    private String introduction;

    private String body;

    private String conclusion;

    public BlogModel() {
    }

    public BlogModel(long id, String authorName, String title, String introduction, String body, String conclusion) {
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.introduction = introduction;
        this.body = body;
        this.conclusion = conclusion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
