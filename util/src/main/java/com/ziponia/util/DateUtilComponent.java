package com.ziponia.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtilComponent {

    /**
     * currentDate 기준 이후의 분 시점을 반환합니다.
     *
     * @param currentDate 변환 할 시간
     * @param afterMinute 변환 할 시점
     * @return java.util.Date
     */
    public static Date toAfterMinute(Date currentDate, int afterMinute) {
        int targetTime = 60 * afterMinute * 1000; // 초
        return new Date(currentDate.getTime() + targetTime);
    }

    /**
     * currentDate 기준 이전의 분 시점을 반환합니다.
     *
     * @param currentDate  변환 할 시간
     * @param beforeMinute 변환 할 시점
     * @return java.util.Date
     */
    public static Date toBeforeMinute(Date currentDate, int beforeMinute) {
        int targetTime = 60 * beforeMinute * 1000; // 초
        return new Date(currentDate.getTime() - targetTime);
    }

    /**
     * Date 객체 기준으로 마지막 날짜를 반환합니다.
     *
     * @param date 기준일이 될 Date
     * @return 마지막 날짜.
     */
    public static int lastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 년, 월 기준으로 마지막 날을 반환합니다.
     *
     * @param year  기준 년
     * @param month 기준 월 (ex, 8월 -> month = 8, -1 아닙니다.)
     * @return 마지막 날짜.
     */
    public static int lastDate(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        return cal.getActualMaximum(Calendar.DATE);
    }
}
