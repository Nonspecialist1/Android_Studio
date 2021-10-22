package com.koreait.first.picsum;

/*
- HTTP 통신 방법
1. POST : 로그인 등 가장많이 사용, 은닉화
2. GET : ?쿼리스트링 노출,
3. PUT
4. DELETE
 */

public class PicsumVO {
    private String id;
    private String author;
    private int width;
    private int height;
    private String url;
    private String download_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }
}