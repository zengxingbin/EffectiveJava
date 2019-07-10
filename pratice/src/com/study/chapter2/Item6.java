package com.study.chapter2;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/7/10 0010.
 * 第六条:避免创建不必要的对象
 */
public class Item6 {
    private static final Pattern p = Pattern.compile("");
    //or
    private static Pattern p2;
    public static void main(String[] args) {
        //1.String
        //String str = "hello world";
       // String str2 = new String("hello world");//don't do this
        long startTime = System.currentTimeMillis();
        sum2();
        long endTime = System.currentTimeMillis();
        System.out.print(endTime - startTime);
    }
    public static boolean isRomanNumeralV1(String s) {
        return s.matches("");//dou't do this
    }
    public static boolean isRomanNumeralV2(String s) {

        return p.matcher(s).matches();//recommended
    }
    public static boolean isRomanNumeralV3(String s) {
        if(p2 == null) {
            p2 = Pattern.compile("");//lazy load
        }
        return p2.matcher(s).matches();
    }

    private static long sum() {
        Long sum = 0L;//The type of sum is Long,but long for i,not recommended
        for(long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
    private static long sum2() {
        long sum = 0L;
        for(long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
