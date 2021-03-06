package com.keking.java8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewDateTest {


    public static void main(String[] args) {
        String pattern1="yyyy-MM-dd hh:mm:ss";
        String pattern2="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern1);


    }


















    @Test
    public void testParse() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = Arrays.asList(
                "2019-07-01 10:00:01",
                "2019-07-02 11:00:02",
                "2019-07-03 12:00:03",
                "2019-07-04 13:00:04",
                "2019-07-05 14:00:05"
        );
       // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String str : dateStrList) {
            executorService.execute(() -> {
                try {
                    dateTimeFormatter.parse(str);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }





    @Test
    public void test2(){

        LocalDate localdate = LocalDate.now();
        System.out.println(localdate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.of(localdate, localTime);
        //获取这个月的最后一天
        localDateTime.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));


    }

}
