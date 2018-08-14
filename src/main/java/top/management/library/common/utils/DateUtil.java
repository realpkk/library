package top.management.library.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class DateUtil extends DateUtils{

    public static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "MM/dd/yyyy", "MM/dd/yyyy HH:mm:ss"};

    public static Date parseDate(Object str){
        if (str == null){
            return null;
        }
        try{
            return parseDate(str.toString(),parsePatterns);
        }catch (ParseException e){
            return null;
        }
    }
}
