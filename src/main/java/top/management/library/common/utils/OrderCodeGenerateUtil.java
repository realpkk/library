package top.management.library.common.utils;

import top.management.library.entity.order.Order;

import java.util.Date;

public class OrderCodeGenerateUtil {

    public static String codeGenerate(String bookCode,Integer type,String orderLoginName){

        Long timeStamp = System.currentTimeMillis();
        String timeCode = timeStamp.toString();
        String genBookCode = toASCII(bookCode);
        String typeCode = type.toString();
        String userCode = toASCII(orderLoginName);
        return timeCode+"-"+genBookCode+"-"+typeCode+"-"+userCode;
    }

    public static String toASCII(String str){

        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            stringBuffer.append((int)chars[i]);
        }
        return stringBuffer.toString();
    }
}

