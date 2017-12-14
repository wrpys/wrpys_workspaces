package com.wrpys.app.utils;

import com.wrpys.app.common.ErrorCode;
import com.wrpys.app.exception.WYUnCheckedException;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间处理公共方法
 *
 * @author wrp
 */

public class DateUtils {

    /*yyyyMMddHHmmss*/
    public static final String DATE_FORMAT = "yyyyMMddHHmmss";
    /*yyyyMMddHHmmssSSS*/
    public static final String DATE_FORMAT2 = "yyyyMMddHHmmssSSS";
    /*yyyyMMddHH*/
    public static final String DATE_HOURS_FORMAT = "yyyyMMddHH";
    /*yyyyMMdd*/
    public static final String DATE_SIMP_FORMAT = "yyyyMMdd";
    /*yyyyMM*/
    public static final String DATE_MM_FORMAT = "yyyyMM";
    /*yyyy*/
    public static final String DATE_YYYY_FORMAT = "yyyy";
    /*dd*/
    public static final String DATE_DD_FORMAT = "dd";
    /*yyyy-MM-dd*/
    public static final String DATE_SIMP_FORMAT2 = "yyyy-MM-dd";
    /*yyyy-MM-dd HH:mm:ss*/
    public static final String DATE_FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /*yyyy/MM/dd HH:mm:ss*/
    public static final String DATE_FULL_FORMAT2 = "yyyy/MM/dd HH:mm:ss";
    /*yyyy-MM-dd HH:mm*/
    public static final String DATE_HH_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_HHmm_FORMAT = "yyyyMMdd HH:mm";
    /*HH:mm*/
    public static final String DATE_HHmm = "HH:mm";

    /*YYMMddHH*/
    public static final String DATE_YYMMddHH = "YYMMddHH";


    //对性能要求比较高的情况下,使用ThreadLocal,也是将共享变量变为独享,线程独享肯定能比方法独享在并发环境中能减少不少创建对象的开销。
    private static ThreadLocal<Map<String, DateFormat>> threadLocal = new ThreadLocal<Map<String, DateFormat>>();

    private static DateFormat getDateFormat(String date_format) {
        Map<String, DateFormat> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, DateFormat>();
            threadLocal.set(map);
        }
        //时间格式为空，赋默认值(全时间格式)
        if (StringUtils.isEmpty(date_format)) {
            date_format = DATE_FULL_FORMAT;
        }
        DateFormat df = map.get(date_format);
        //减少new的对象开支
        if (df == null) {
            df = new SimpleDateFormat(date_format);
            map.put(date_format, df);
        }
        return df;
    }

    /**
     * 得到当前系统时间
     *
     * @return
     */
    public static Date getCurrDate() {
        Calendar gc = new GregorianCalendar();
        return gc.getTime();
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param formatString
     * @return
     */
    public static String formatDate(Date date, String formatString) {
        return getDateFormat(formatString).format(date);
    }

    public static String formatDate(Date date, SimpleDateFormat sdf) {
        return sdf.format(date);
    }

    /**
     * funcion   getCurrDate
     * purpose   获取今天所在的年月日（格式：yyyy-mm-dd）
     *
     * @param sDateFormat 时间格式如：YYYY-MM-DD 或MM
     * @return 当时间的格式串
     * @see
     */
    public static String getCurrDate(String sDateFormat) {
        Calendar gc = new GregorianCalendar();
        Date date = gc.getTime();
        String result = getDateFormat(sDateFormat).format(date);
        return result;
    }

    /**
     * 按YYYYMMDD格式解析日期字符串为日期
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        try {
            Date date = getDateFormat(DATE_SIMP_FORMAT).parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    /**
     * @param dateTime
     * @return Date
     */
    public static Date parseDate(long dateTime) {
        try {
            Date date = new Date(dateTime);
            return date;
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    public static Date parseDateHour(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        try {
            Date date = getDateFormat(DATE_HOURS_FORMAT).parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    /**
     * 按YYYYMMDD格式解析日期字符串为日期
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr, String dateFormat) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        try {
            Date date = getDateFormat(dateFormat).parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    public static Date parseDate(String dateStr, SimpleDateFormat sf) {
        try {
            return sf.parse(dateStr);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 按YYYYMMDDHH24MISS格式解析日期字符串为日期
     *
     * @param dateStr
     * @return
     */
    public static Date parseDateFull(String dateStr) {
        try {
            Date date = getDateFormat(DATE_FORMAT).parse(dateStr);
            return date;
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
    }

    /**
     * 按给定格式输出系统时间的字符串
     *
     * @param formatStr
     * @return
     */
    public static String getSysDateByFormat(String formatStr) {
        String datestr = "";
        try {
            Date date = new Date();
            datestr = getDateFormat(formatStr).format(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        return datestr;
    }

    /**
     * 检查是否过期(YYYYMMDD)
     *
     * @param expiredDate
     * @return
     */
    public static boolean checkExpired(String expiredDate) {
        if (expiredDate == null || "".equals(expiredDate) || "0".equals(expiredDate)) {
            return false;
        }

        Date expDate = DateUtils.parseDate(expiredDate);
        Date curDate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(expDate);
        Calendar calCur = new GregorianCalendar();
        calCur.setTime(curDate);

        if (cal.compareTo(calCur) >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否过期（时间段内）
     *
     * @param inureDate
     * @param expiredDate
     * @return
     */
    public static boolean checkExpired(String inureDate, String expiredDate) {
        if (inureDate == null || "".equals(inureDate)) {
            return false;
        }
        if (expiredDate == null || "".equals(expiredDate)) {
            return false;
        }

        Date inuDate = DateUtils.parseDate(inureDate);
        Date expDate = DateUtils.parseDate(expiredDate);
        Date curDate = new Date();

        Calendar calInu = new GregorianCalendar();
        calInu.setTime(inuDate);

        Calendar calExp = new GregorianCalendar();
        calExp.setTime(expDate);

        Calendar calCur = new GregorianCalendar();
        calCur.setTime(curDate);

        int i = calCur.compareTo(calInu);
        int j = calCur.compareTo(calExp);
        if (i > 0 && j <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查是否过期(YYYYMMDDHH24MISS)
     *
     * @param expiredDate
     * @return
     */
    public static boolean checkExpiredFull(String expiredDate) {
        Date expDate = DateUtils.parseDateFull(expiredDate);
        Date curDate = new Date();

        Calendar cal = new GregorianCalendar();
        cal.setTime(expDate);
        Calendar calCur = new GregorianCalendar();
        calCur.setTime(curDate);

        if (cal.compareTo(calCur) >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否在两个时间段内（YYYYMMDDHH24MISS）
     *
     * @param inureDate
     * @param expiredDate
     * @return
     */
    public static boolean checkExpiredFull(String inureDate, String expiredDate) {
        if (inureDate == null || "".equals(inureDate)) {
            return false;
        }
        if (expiredDate == null || "".equals(expiredDate)) {
            return false;
        }

        Date inuDate = DateUtils.parseDateFull(inureDate);
        Date expDate = DateUtils.parseDateFull(expiredDate);
        Date curDate = new Date();

        Calendar calInu = new GregorianCalendar();
        calInu.setTime(inuDate);

        Calendar calExp = new GregorianCalendar();
        calExp.setTime(expDate);

        Calendar calCur = new GregorianCalendar();
        calCur.setTime(curDate);

        int i = calCur.compareTo(calInu);
        int j = calCur.compareTo(calExp);
        if (i > 0 && j < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 按一定格式获取几天前或几天后的日期字符串
     *
     * @param days，日期时长
     * @param timeFormat，日期格式 例如'yyyyMMdd'
     * @return String 日期字符串
     */
    public static String getSomeDaysAgoDate(int days, String timeFormat) {
        Calendar calInu = Calendar.getInstance();
        calInu.add(Calendar.DATE, days);
        Date d = calInu.getTime();
        String newdate = getDateFormat(timeFormat).format(d);
        return newdate;
    }

    /**
     * 获取星期几<br>
     * （原先的cal的返回是1-周日，2-周一...，现在要变成1-周一，... 7-周日)
     *
     * @return int 星期几
     */
    public static int getWeekDay() {
        Calendar cal = Calendar.getInstance();
        int ret = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (ret == 0) {
            ret = 7;
        }
        return ret;
    }

    /**
     * 获取某个月的最后一天的字符串
     *
     * @param dateStr 输入日期，格式可以是'yyyyMM'或yyyyMMdd
     * @return String 日期字符串，例如'20080131'
     */
    public static String getLastDayOfMonth(String dateStr) {
        if (dateStr.length() < 8) {
            dateStr = dateStr + "01";
        }
        Calendar calendar = new GregorianCalendar();

        String format = DATE_SIMP_FORMAT;
        if (dateStr != null && dateStr.trim().length() == 6) {
            format = DATE_MM_FORMAT;
        }
        try {
            Date date = getDateFormat(format).parse(dateStr);
            calendar.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }

        calendar.roll(Calendar.MONDAY, 0);//0取本月最后一天，1取下一个月的最后一天，-1取上一个月的最后一天
        calendar.roll(Calendar.DATE, 0 - calendar.get(Calendar.DATE));
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return getDateFormat(format).format(calendar.getTime()).substring(6, 8);
    }

    /**
     * 获取输入的时间运算后时间
     *
     * @param sDate  当前时间
     * @param iIndex 1:年
     *               2:月
     *               3:日
     *               4:小时
     *               5:分钟
     *               6:秒
     *               iDistance 间隔
     * @author guoss
     */
    public static String getTime(String sDate, int iIndex, int iDistance) {
        String sTemp;
        try {
            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.YEAR, Integer.parseInt(sDate.substring(0, 4), 10));
            cal.set(Calendar.MONTH, Integer.parseInt(sDate.substring(4, 6), 10) - 1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sDate.substring(6, 8), 10));

            if (iIndex == 1) {
                cal.add(Calendar.YEAR, iDistance);
            } else if (iIndex == 2) {
                cal.add(Calendar.MONTH, iDistance);
            } else if (iIndex == 3) {
                cal.add(Calendar.DAY_OF_MONTH, iDistance);
            }
            sTemp = cal.get(Calendar.YEAR) + "";
            sTemp += DateUtils.getFullLength(cal.get(Calendar.MONTH) + 1, 2);
            sTemp += DateUtils.getFullLength(cal.get(Calendar.DAY_OF_MONTH), 2);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        return sTemp;
    }

    /**
     * 在一个整数前面补给定个数零
     *
     * @param iOral   : 原来的数
     * @param iLength : 补充为几位
     * @return String : 补了一些零后使之达到一个个数（前补零）
     */
    private static String getFullLength(int iOral, int iLength) {
        int iIndex = ("" + iOral).length();
        if (iIndex > iLength) {
            return "" + iOral;
        }
        String sTemp = "" + iOral;
        for (int i = 0; i < iLength - iIndex; i++) {
            sTemp = "0" + sTemp;
        }
        return sTemp;
    }

    /**
     * 获取上个月份
     *
     * @param dateStr
     * @return
     */
    public static String getLastMonth(String dateStr) {
        Calendar calendar = new GregorianCalendar();
        String format = DATE_SIMP_FORMAT;
        if (dateStr != null && dateStr.trim().length() == 6) {
            format = DATE_MM_FORMAT;
        }
        try {
            Date date = getDateFormat(format).parse(dateStr);
            calendar.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        calendar.add(Calendar.MONTH, -1);
        return getDateFormat(format).format(calendar.getTime()).toString();
    }

    /**
     * 获取上一天
     *
     * @param dateStr
     * @return
     */
    public static String getLastDay(String dateStr) {
        Calendar calendar = new GregorianCalendar();
        String format = DATE_SIMP_FORMAT;
        if (dateStr != null && dateStr.trim().length() == 6) {
            format = DATE_MM_FORMAT;
        }
        try {
            Date date = getDateFormat(format).parse(dateStr);
            calendar.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        calendar.add(Calendar.DATE, -1);
        return getDateFormat(format).format(calendar.getTime()).toString();
    }

    /**
     * 获取当前的年份
     *
     * @return
     */
    public static String getYear() {
        Calendar cal = Calendar.getInstance();
        int ret = cal.get(Calendar.YEAR);
        return String.valueOf(ret);
    }

    /**
     * 获取当前的月份
     *
     * @return
     */
    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        int ret = cal.get(Calendar.MONTH) + 1;
        return String.valueOf(ret);
    }

    /**
     * @param date
     * @return
     * @Function:     getMonth 
     * @Description:  获取给定时间的月份数值，如果给定的日期为null，返回为null
     */
    public static Integer getMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * 获取几个月前的月份
     *
     * @param month    当前月
     * @param monthNum 月数
     * @return
     */
    public static String getLastMonths(String month, int monthNum) {
        Calendar calendar = new GregorianCalendar();
        String format = DATE_SIMP_FORMAT;
        if (month != null && month.trim().length() == 6) {
            format = DATE_MM_FORMAT;
        }
        try {
            Date date = getDateFormat(format).parse(month);
            calendar.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        calendar.add(Calendar.MONTH, -monthNum);
        return getDateFormat(format).format(calendar.getTime()).toString();
    }

    /**
     * 获取几个月后的月份
     *
     * @param month    当前月
     * @param monthNum 月数
     * @return
     */
    public static String getNextMonths(String month, int monthNum) {
        Calendar calendar = new GregorianCalendar();
        String format = DATE_SIMP_FORMAT;
        if (month != null && month.trim().length() == 6) {
            format = DATE_MM_FORMAT;
        }
        try {
            Date date = getDateFormat(format).parse(month);
            calendar.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        calendar.add(Calendar.MONTH, +monthNum);
        return getDateFormat(format).format(calendar.getTime()).toString();
    }

    /**
     * 获取两个时间相差的天数
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static long getSubDate(String startDate, String endDate) {
        Calendar cal = new GregorianCalendar();
        Calendar cal1 = new GregorianCalendar();
        String format = DATE_SIMP_FORMAT;
        try {
            if (startDate != null && startDate.trim().length() == 6) {
                format = DATE_MM_FORMAT;
            }
            Date st_date = getDateFormat(format).parse(startDate);
            cal.setTime(st_date);

            if (endDate != null && endDate.trim().length() == 6) {
                format = DATE_MM_FORMAT;
            }
            Date date = getDateFormat(format).parse(endDate);
            cal1.setTime(date);
        } catch (Exception e) {
            throw new WYUnCheckedException(ErrorCode.BUSERROR_DATE_PARSER, e);
        }
        return (cal1.getTime().getTime() - cal.getTime().getTime()) / (24 * 60 * 60 * 1000);
    }

    public synchronized static String getDefaultFirstDate(int circle_id, int Date_Bwtween) {
        String tj_date = "";
        Calendar curdate = Calendar.getInstance();
        if (circle_id == 1) {
            curdate.add(Calendar.DATE, 1 - Date_Bwtween);
            Date d = curdate.getTime();
            tj_date = getDateFormat(DATE_SIMP_FORMAT).format(d);
            curdate.add(Calendar.DATE, Date_Bwtween - 1);
        } else if (circle_id == 11) {
            curdate.add(Calendar.DATE, 1);
            curdate.add(Calendar.MONTH, -1 * Date_Bwtween);
            Date d = curdate.getTime();
            tj_date = getDateFormat(DATE_MM_FORMAT).format(d);
            curdate.add(Calendar.MONTH, Date_Bwtween);
            curdate.add(Calendar.DATE, -1);
        } else if (circle_id == 2) {
            curdate.add(Calendar.DATE, 1);
            Date d = curdate.getTime();
            int dd = Integer.parseInt(getDateFormat(DATE_DD_FORMAT).format(d));
            if (dd <= 7) {
                dd = 4;
                curdate.add(Calendar.MONTH, -1);
            } else if (dd <= 14) {
                dd = 1;
            }
            else if (dd <= 21) {
                dd = 2;
            }
            else {
                dd = 3;
            }

            d = curdate.getTime();
            tj_date = getDateFormat(DATE_MM_FORMAT).format(d) + "0" + String.valueOf(dd);
            int yyyy = Integer.parseInt(tj_date) / 10000;
            int mm = (Integer.parseInt(tj_date) / 100) % 100;
            int day = Integer.parseInt(tj_date) % 100;
            day = day - (Date_Bwtween % 4) + 1;
            int i = 0;
            while (1 > 0) {
                if (day > 0) {
                    break;
                }
                day += 4;
                i++;
            }
            mm = mm - i - (Date_Bwtween / 4);
            i = 0;
            while (1 > 0) {
                if (mm > 0) {
                    break;
                }
                mm += 12;
                i++;
            }
            yyyy -= i;
            tj_date = String.valueOf(yyyy * 10000 + mm * 100 + day);
            if (dd == 4) {
                curdate.add(Calendar.MONTH, 1);
            }
            curdate.add(Calendar.DATE, -1);
        } else if (circle_id == 21) {
            curdate.add(Calendar.DATE, 1);
            curdate.add(Calendar.YEAR, -1 * Date_Bwtween);
            Date d = curdate.getTime();
            tj_date = getDateFormat(DATE_YYYY_FORMAT).format(d);
            curdate.add(Calendar.YEAR, Date_Bwtween);
            curdate.add(Calendar.DATE, -1);
        }
        return tj_date;
    }

    /**
     * @param time 操作的时间对象
     * @param sec  秒数
     * @return
     * @Function:     addTimeSec 
     * @Description:  针对时间对象做加法处理.  
     */
    public static long addTimeSec(long time, long sec) {
        if (time == 0) {
            return time;
        }
        return time + sec;
    }

    /**
     * @param time1 被减数时间
     * @param time2 减数时间
     * @return 毫秒
     * @Function:     minusTimeMillcSec 
     * @Description:  针对时间对象加法处理  
     */
    public static long minusTimeMillcSec(long time1, long time2) {
        if (time1 == 0) {
            return 0;
        }
        return time1 - time2;
    }

    /**
     * @param time1 被减数时间
     * @param time2 减数时间
     * @return 秒
     * @Function:     minusTimeSec 
     * @Description:  针对时间对象加法处理   减数时间
     */
    public static long minusTimeSec(long time1, long time2) {
        return Math.round(minusTimeMillcSec(time1, time2) / 1000);
    }

    /**
     * 时间相减
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long minusTimeMillcSec(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return 0;
        }
        return d1.getTime() - d2.getTime();
    }

    public static long minusTimeSec(Date d1, Date d2) {
        return Math.round(minusTimeMillcSec(d1, d2) / 1000);
    }

    /**
     * 增加几天或减少几天
     *
     * @param dateStr
     * @param num
     * @return
     */
    public static String recalDay(String dateStr, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate(dateStr));
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return formatDate(calendar.getTime(), DATE_SIMP_FORMAT);
    }

    /**
     * 增加几天或减少几天
     *
     * @param obj 支持Date类型和String类型日期
     * @param num 天数
     * @return 返回增加或减少num天后的日期
     */
    public static String recalDate(Object obj, int num) {
        Calendar calendar = Calendar.getInstance();
        if (obj instanceof Date) {
            calendar.setTime((Date) obj);
        } else if (obj instanceof String) {
            calendar.setTime(parseDate(obj.toString()));
        }
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return formatDate(calendar.getTime(), DATE_SIMP_FORMAT);
    }

    /**
     * 增加几天或减少几天
     *
     * @param dateStr String类型日期
     * @param num     天数
     * @param format  格式
     * @return 返回增加或减少num天后的日期
     */
    public static String recalDate(String dateStr, int num, String format) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        calendar.setTime(sdf.parse(dateStr));
        calendar.add(Calendar.DATE, num);
        return sdf.format(calendar.getTime());
    }

    /**
     * 增加几小时
     *
     * @param dateStr
     * @return
     */
    public static String recalHour(String dateStr, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDateHour(dateStr));
        calendar.add(Calendar.HOUR_OF_DAY, num);
        return formatDate(calendar.getTime(), DATE_HOURS_FORMAT);
    }

    /**
     * @param date
     * @Function:     cleanDateToDay 
     * @Description:  清理date数据为YYYYMMDD (删除时、分、秒、毫秒)
     */
    public static Date cleanDateToDay(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 判断系统时间是否一个月的第一天
     *
     * @return
     */
    public static boolean isFirstDayOfMonth() {
        Date currDate = DateUtils.cleanDateToDay(new Date());
        String firstDayStr = DateUtils.getCurrDate(DateUtils.DATE_MM_FORMAT) + "01";
        Date firstDay = DateUtils.parseDate(firstDayStr);
        if (currDate.equals(firstDay)) {
            return true;
        }
        return false;
    }

    /**
     * 判断传入的日期是否是当月的第一天
     * 比如传入的日期为20160101，那么返回:true，否则返回:false
     *
     * @param date
     * @return
     */
    public static boolean isFirstDayOfMonth(String date) {
        Date cpDate = DateUtils.parseDate(date, DateUtils.DATE_SIMP_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(cpDate);
        cal.set(Calendar.DAY_OF_MONTH, 1);//设置本月第一天
        Date firstDay = cal.getTime();
        if (cpDate.equals(firstDay)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否超时
     *
     * @param stateTime 开始时间
     * @param endTime   结束时间
     * @param overtime  超时时间限制，以秒为单位
     * @return true：超时，false：非超时
     */
    public static boolean isOverTime(Date stateTime, Date endTime, int overtime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(stateTime);
        cal.add(Calendar.SECOND, overtime);
        Date limitTime = cal.getTime();
        if (endTime.after(limitTime)) {
            return true;
        } else {
            return false;
        }
    }

}
