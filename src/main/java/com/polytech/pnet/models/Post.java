package com.polytech.pnet.models;

public class Post {

    private String content;
    private long id;

    public Post(String content) {
        this.content = content;
    }

    protected Post() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }
}
