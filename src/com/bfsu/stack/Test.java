package com.bfsu.stack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {


    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{

            Date d1 = df.parse("2016-06-06 10:07:40");

            Date d2 = df.parse("2015-06-05 11:30:24");
            long diff = d1.getTime() - d2.getTime();//�����õ��Ĳ�ֵ��΢�뼶��

            long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);

            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

            System.out.println(""+days+"��"+hours+"Сʱ"+minutes+"��");

        }
        catch (Exception e)
        {
        }
    }
}
