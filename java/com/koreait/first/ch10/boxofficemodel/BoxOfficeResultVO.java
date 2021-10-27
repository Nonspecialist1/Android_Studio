package com.koreait.first.ch10.boxofficemodel;

import java.util.List;

public class BoxOfficeResultVO {
    // 통신할 때는 변수명이 중요하지 클래스명 따위는 하나도 안 중요하다 !
    private String boxOfficeType;
    private String showRange;
    private List<BoxOfficeVO> dailyBoxOfficeList;

    private String yearWeekTime;
    private List<BoxOfficeVO> weeklyBoxOfficeList;

    public String getYearWeekTime() { return yearWeekTime; }

    public void setYearWeekTime(String yearWeekTime) { this.yearWeekTime = yearWeekTime; }

    public List<BoxOfficeVO> getWeeklyBoxOfficeList() { return weeklyBoxOfficeList; }

    public void setWeeklyBoxOfficeList(List<BoxOfficeVO> weeklyBoxOfficeList) { this.weeklyBoxOfficeList = weeklyBoxOfficeList; }


    public String getBoxOfficeType() {
        return boxOfficeType;
    }

    public void setBoxOfficeType(String boxOfficeType) {
        this.boxOfficeType = boxOfficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public List<BoxOfficeVO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<BoxOfficeVO> dailyBoxOfficeList) { this.dailyBoxOfficeList = dailyBoxOfficeList; }
}
