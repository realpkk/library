package top.management.library.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;


public class ExpireDateUtil {

    public static Date dateCalculate(Date date,Integer orderPeriod) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (orderPeriod) {
            case 1:
                calendar.add(Calendar.MONTH,1);
                break;
            case 2:
                calendar.add(Calendar.MONTH,4);
                break;
            case 3:
                calendar.add(Calendar.MONTH,6);
                break;
            case 4:
                calendar.add(Calendar.YEAR,1);
                break;
            default:
                break;
        }
        date = calendar.getTime();
        return date;
    }

    public static Date getOriginalExpireTime(Date expireTime,Integer orderPeriod){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expireTime);
        switch (orderPeriod) {
            case 1:
                calendar.add(Calendar.MONTH,-1);
                break;
            case 2:
                calendar.add(Calendar.MONTH,-4);
                break;
            case 3:
                calendar.add(Calendar.MONTH,-6);
                break;
            case 4:
                calendar.add(Calendar.YEAR,-1);
                break;
            default:
                break;
        }
        Date originalExpireTime = calendar.getTime();
        return originalExpireTime;
    }
}
