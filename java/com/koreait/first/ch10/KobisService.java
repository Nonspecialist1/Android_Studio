package com.koreait.first.ch10;

import com.koreait.first.ch10.boxofficemodel.BoxOfficeResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieInfoResultBodyVO;
import com.koreait.first.ch10.searchmoviemodel.MovieListResultBodyVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KobisService {
    //일별 박스오피스
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    Call<BoxOfficeResultBodyVO> searchDailyBoxOfficeList(
            @Query("key") String key, @Query("targetDt") String targetDt
    );

    //주간 박스오피스 0
    @GET("boxoffice/searchWeeklyBoxOfficeList.json?weekGb=0")
    Call<BoxOfficeResultBodyVO> searchWeeklyBoxOfficeList(
            @Query("key") String key, @Query("targetDt") String targetDt
    );
    //영화목록 검색
    @GET("movie/searchMovieList.json")
    Call<MovieListResultBodyVO> searchMovieList(
            @Query("key") String key,
            @Query("itemPerPage") String itemPerPage,
            @Query("curPage") int curPage
    );
    //영화 상세정보
    @GET("movie/searchMovieInfo.json")
    Call<MovieInfoResultBodyVO> searchMovieInfo(
            @Query("key") String key, @Query("movieCd") String movieCd
    );


}
