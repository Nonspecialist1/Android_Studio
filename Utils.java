package com.koreait.first;

public class Utils {
    // 문제가 발생되면 0리턴, 발생안되면 파싱한다.
    public static int parseStringToInt(String val){
        int intVal = 0;

        try {
            intVal = Integer.parseInt(val);;
        } catch(Exception e){
            e.printStackTrace();
        } finally {

        }
        return intVal;






        //예외처리
        /*
        try {

        } catch (Exception e) {
            // 예외 발생 시 실행하고 싶은 것들을 여기 작성
            e.printStackTrace(); // 에러 내용을 로그에 찍는 함수
        } finally { //옵션, 없어도 됌
            // 에러가 터지든 안터지든 !!무조건!! 실행됐으면 하는 것 작성
        }
        */


    }
}
