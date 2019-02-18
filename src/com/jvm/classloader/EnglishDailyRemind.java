package com.jvm.classloader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
// 距离今日1,4,7,9,11,13
public class EnglishDailyRemind {
    public static void main(String[] args) {
        String folder = "C:\\Users\\Administrator\\Desktop\\粗人\\Words";
        File folderFile = new File(folder);
        Calendar today = new GregorianCalendar();
        System.out.println("Today:" + fmt(today.getTime()));
        System.out.println("Welcome to use this system, then you should read following files:");
        if (folderFile.isDirectory()) {
            File[] files = folderFile.listFiles();
            for (File file : files) {
                String name = file.getName();
                if (name.startsWith("1") && name.endsWith(".xlsx")) {
                    name = "20" + name;
                    name = name.replace(".xlsx", "");
                    String[] ss = name.split("-");
                    Calendar calendar = new GregorianCalendar(Integer.parseInt(ss[0]), 
                            Integer.parseInt(ss[1])-1, Integer.parseInt(ss[2]));
                    if (today.getTime().after(calendar.getTime())){
                        //System.out.println(fmt(today.getTime()) + "###" + fmt(calendar.getTime()));
                        long t = today.getTime().getTime() - calendar.getTime().getTime();
                        long days = t / 1000 / 60 / 60 / 24;
                        if (days % 4 == 0) {
                            System.out.println(file.getName());
                        }
                    }
                    
                }
                
            }
        }
    }
    public static String fmt(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
