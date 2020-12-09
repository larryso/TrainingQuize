package com.cognizant.exam.utils;

public class ExamUtils {
    public static int countStr(String str1, String str2) {
        int counter=0;
        int length = str1.length();
        for(int i=0;i<length;i++){
            char rightIndex = str1.charAt(i);
            char myIndex = str2.charAt(i);
            if(rightIndex == myIndex){
                counter++;
            }
        }
        return counter;
    }
}
