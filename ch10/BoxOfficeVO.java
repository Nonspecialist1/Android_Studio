package com.koreait.first.ch10;

public class BoxOfficeVO {
    private String rank;
    private String movieNm;
    private String openDt;
    private String audiCnt;

    public String getAudiCnt() { return audiCnt; }

    public void setAudiCnt(String audiCnt) { this.audiCnt = audiCnt; }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }
}
