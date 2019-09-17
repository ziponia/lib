package com.ziponia.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

@RunWith(JUnit4.class)
public class DateUtilComponentTest {

    @Test
    public void dateLastTest() {

        int year = 2018;
        int month = 2;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int last = DateUtilComponent.lastDate(cal.getTime());

        System.out.println(String.format("%d 년 %d월 의 마지막날은 %d일 입니다.", year, month - 1, last));

        // 2018 년 2월은 28 일까지 입니다.
        Assert.assertEquals(28, last);
    }

    @Test
    public void dateLastByYM() {
        int year = 2019;
        int month = 6;

        int last = DateUtilComponent.lastDate(year, month);

        System.out.println(String.format("%d 년 %d월 의 마지막날은 %d일 입니다.", year, month, last));

        // 2019 년 6월은 30 일까지 입니다.
        Assert.assertEquals(30, last);
    }
}