package com.koreait.first.ch10.searchmoviemodel;

public class MovieInfoResultVO {
    private MovieInfoVO movieInfo; // JS 중괄호{}는 객체 1개임,,List 사용하려면 [{},{}...]이런식으로 대괄호가 나와야함 !
    private String source;

    public MovieInfoVO getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfoVO movieInfo) {
        this.movieInfo = movieInfo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
