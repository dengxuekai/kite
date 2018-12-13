package com.dxk.kite.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat simpleDateFormat;

    public static final String yyyyMMdd2 = "yyyy-MM-dd";
    public static final String yyyyMMdd3 = "yyyy/MM/dd";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String MMdd = "MM-dd";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final long MILLIS_OF_MINUTE = 60 * 1000;
    public static final long MILLIS_OF_HOUR = MILLIS_OF_MINUTE * 60;
    public static final long MILLIS_OF_DAY = MILLIS_OF_HOUR * 24;

    /**
     * 以默认格式'yyyy-MM-dd HH:mm:ss'进行日期解析
     */
    public static Date parse(String dateString) {
        return parse(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parse(String dateString, String format) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
        try {
            DATE_FORMAT.applyPattern(format);
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Timestamp toTimestamp(long timeMillis) {
        return new Timestamp(timeMillis);
    }

    public static Integer toYMD(long timeMillis) {
        String ymd = format(timeMillis, "yyyyMMdd");
        return Integer.valueOf(ymd);
    }

    public static Integer toYMD(Date date) {
        String ymd = format(date, "yyyyMMdd");
        return Integer.valueOf(ymd);
    }

    public static Timestamp toTimestamp(Date d) {
        return new Timestamp(d.getTime());
    }

    public static String format(long millis) {
        return format(millis, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date d) {
        return format(d, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDfTimeStr() {
        return format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeStr(Date date, String pattern) {
        return format(date.getTime(), pattern);
    }

    /**
     * 获得当月的第一天早上的时间
     *
     * @return
     */
    public static Date getMonthFirstDayMorning() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getMonthFirstDayMorning(Date dateTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获得当月的第一天晚上的时间
     *
     * @return
     */
    public static Date getMonthFirstDayNight() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获得当月的最后一天晚上的时间
     *
     * @return
     */
    public static Date getMonthLastDayNight() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为最后一号,当前日期既为本月最后一天
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getMonthLastDayNight(Date dateTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为最后一号,当前日期既为本月最后一天
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getYesterdayMorning() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getYesterdayNight() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getTodayMorning() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getTodayNight() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }


    public static Date getTomorrowMorning() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getTomorrowNight() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static Date getAddMonth(Date old, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(old);
        calendar.add(Calendar.MONTH, days);
        return calendar.getTime();
    }

    public static Date getAddDate(Date old, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(old);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    public static Date getAddHours(Date old, int hours) {
        Calendar c = Calendar.getInstance();
        c.setTime(old);
        c.add(Calendar.HOUR_OF_DAY, hours);
        return c.getTime();
    }

    public static Date getAddMinutes(Date old, int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(old);
        c.add(Calendar.MINUTE, minutes);
        return c.getTime();
    }

    public static Date getAddSeconds(Date old, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(old);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    public static String format(long millis, String format) {
        return format(new Date(millis), format);
    }

    public static String format(Date d, String format) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
        DATE_FORMAT.applyPattern(format);
        return DATE_FORMAT.format(d);
    }

    public static String format2HMS(long duration) {
        long ms = duration % 1000;
        long s = duration / 1000;
        long m = s / 60;
        s = s % 60;
        long h = m / 60;
        m = m % 60;
        return h + "小时" + m + "分钟" + s + "秒" + ms + "毫秒";
    }

    /**
     * 获取指定日期指定时间点的时间
     */
    public static Date getTime(Date date, Date timePoint) {
        String dateStr = DateUtil.format(date, "yyyy-MM-dd");
        String timeStr = DateUtil.format(timePoint, "HH:mm:ss");
        String dt = dateStr + " " + timeStr;
        return DateUtil.parse(dt, "yyyy-MM-dd HH:mm:ss");
    }

    public static int dayForWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取下周的指定时间点时间
     */
    public static Date getTimePointInNextWeek(Date timePoint) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 7);

        return getTime(c.getTime(), timePoint);
    }


    /**
     * 对参数截取日期做比较<br> 与普通的日期比较，其特殊性在于其忽略时间而只对日期进行对比<br> 如d1='2012-12-13 12:22:13' d2='2012-12-13 12:44:13' 返回0
     *
     * @return d1>d2:-1; d1=d2:0; d1<d2:1
     */
    public static int compare(Date d1, Date d2) {
        return org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(d1, d2, Calendar.DATE);
    }

    /**
     * 获得两个日期之间是存在几年内
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDiffYear(Date date1, Date date2) {
        simpleDateFormat = new SimpleDateFormat(DateUtil.yyyyMMdd2);
        int i = 0;
        Integer data1Year = Integer.valueOf(simpleDateFormat.format(date1).split("-")[0]);
        Integer data2Year = Integer.valueOf(simpleDateFormat.format(date2).split("-")[0]);
        if (data2Year.intValue() == data1Year.intValue()) {
            i = 0;
        } else {
            i = Math.abs(data1Year - data2Year);
        }
        return i;
    }

    /**
     * 获得两个日期是存在几个月内
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDiffMonth(Date date1, Date date2) {
        simpleDateFormat = new SimpleDateFormat(DateUtil.yyyyMMdd2);
        int i = 0;
        Integer data1Year = Integer.valueOf(simpleDateFormat.format(date1).split("-")[0]);
        Integer data1Month = Integer.valueOf(simpleDateFormat.format(date1).split("-")[1]);
        Integer data2Year = Integer.valueOf(simpleDateFormat.format(date2).split("-")[0]);
        Integer data2Month = Integer.valueOf(simpleDateFormat.format(date2).split("-")[1]);
        if (data2Year.intValue() == data1Year.intValue()) {
            i = Math.abs(data1Month - data2Month) + 1;
        } else if (data2Year > data1Year && data1Month >= data2Month) {
            i = Math.abs(data1Year - data2Year) * 12 - Math.abs(data1Month - data2Month) + 1;
        } else if (data2Year > data1Year && data1Month <= data2Month) {
            i = Math.abs(data1Year - data2Year) * 12 + Math.abs(data1Month - data2Month) + 1;
        } else if (data2Year < data1Year && data1Month >= data2Month) {
            i = Math.abs(data1Year - data2Year) * 12 + Math.abs(data1Month - data2Month) + 1;
        } else if (data2Year < data1Year && data1Month <= data2Month) {
            i = Math.abs(data1Year - data2Year) * 12 - Math.abs(data1Month - data2Month) + 1;
        }
        return i;
    }

    /**
     * 返回两个日期之间隔了多少天
     */
    public static int getDiffDay(Date endDate, Date startDate) {
        int i = (int) ((endDate.getTime() - startDate.getTime()) / 3600 / 24 / 1000);
        return i;
    }

    public static int getDiffDaysBetweenTruncatedDate(Date endDate, Date startDate) {

        Date truncatedDate1 = org.apache.commons.lang3.time.DateUtils.truncate(endDate, Calendar.DATE);
        Date truncatedDate2 = org.apache.commons.lang3.time.DateUtils.truncate(startDate, Calendar.DATE);

        Long diffDays = (truncatedDate1.getTime() - truncatedDate2.getTime()) / 3600 / 24 / 1000;
        return diffDays.intValue();
    }


    /**
     * 返回两个日期之间隔了多少小时
     */
    public static int getDiffHour(Date endDate, Date startDate) {
        int i = (int) ((endDate.getTime() - startDate.getTime()) / 60 / 60 / 1000);
        return i;
    }

    /**
     * 返回两个日期之间隔了多少分钟
     */
    public static int getDiffMinute(Date endDate, Date startDate) {
        int i = (int) ((endDate.getTime() - startDate.getTime()) / 60 / 1000);
        return i;
    }

    /**
     * 返回两个日期之间隔了多少秒
     */
    public static int getDiffSecond(Date endDate, Date startDate) {
        int i = (int) ((endDate.getTime() - startDate.getTime()) / 1000);
        return i;
    }

    public static int getDiffSecondToNight() {
        Date now = new Date();
        return getDiffSecond(getDayNight(now), now);
    }

    public static int getDiffSecondToNight(Date now) {
        return getDiffSecond(getDayNight(now), now);
    }


    public static Date getDayNight(Date dateTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        Date date = c.getTime();
        return date;
    }

    public static Date getDayMorning(Date dateTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date date = c.getTime();
        return date;
    }

    /**
     * 获取当日指定小时的date
     */
    public static Date getDateTodayHour(int hour) {
        if (hour < 0) {
            hour = 0;
        } else if (hour > 24) {
            hour = 24;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(now());
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date = c.getTime();
        return date;
    }

    /**
     * 现在
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 昨天
     */
    public static Date yesterday() {
        return new Date(System.currentTimeMillis() - MILLIS_OF_DAY);
    }

    /**
     * 明天
     */
    public static Date tomorrow() {
        return new Date(System.currentTimeMillis() + MILLIS_OF_DAY);
    }

    /**
     * n天前
     */
    public static Date daysAgo(int n) {
        return new Date(System.currentTimeMillis() - n * MILLIS_OF_DAY);
    }

    /**
     * n天前
     */
    public static Date daysAgo(Date date, int n) {
        return new Date(date.getTime() - n * MILLIS_OF_DAY);
    }

    /**
     * n天后
     */
    public static Date daysLater(int n) {
        return new Date(System.currentTimeMillis() + n * MILLIS_OF_DAY);
    }

    /**
     * n天后
     */
    public static Date daysLater(Date date, int n) {
        return new Date(date.getTime() + n * MILLIS_OF_DAY);
    }

    /**
     * 计算日期是否在指定的范围之内
     */
    public static boolean dateIsBetween(Date date, String startDateStr, String endDateStr) {
        return date.after(parse(startDateStr)) && date.before(parse(endDateStr));
    }

    /**
     * 计算日期是否在指定的范围之间 包含两端点
     */
    public static boolean dateBetweenOrEqual(Date date, String startDateStr, String endDateStr) {
        return !date.before(parse(startDateStr)) && !date.after(parse(endDateStr));
    }

    /**
     * 计算日期是否在指定的范围之内
     */
    public static boolean dateIsBetween(Date date, Date startDate, Date endDate) {
        return date.after(startDate) && date.before(endDate);
    }

    /**
     * 计算日期是否在指定的范围之间 包含两端点
     */
    public static boolean dateBetweenOrEqual(Date date, Date startDate, Date endDate) {
        return !date.before(startDate) && !date.after(endDate);
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return org.apache.commons.lang3.time.DateUtils.isSameDay(date1, date2);
    }

    /**
     * 判断两个日期是否为同一月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameMonth(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 判断两个日历是否为同一月
     *
     * @param cal1
     * @param cal2
     * @return
     */
    public static boolean isSameMonth(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 获取  今天之前的某一个日期
     *
     * @param nowDate     今天
     * @param beforeDay   今天前的多少天
     * @param brforeMonth 今天前的多少月
     * @param beforeyear  今天前 多少年
     * @return
     */
    public static Date getBeforeThisDate(Date nowDate, int beforeDay, int brforeMonth, int beforeyear) {
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(nowDate);//把当前时间赋给日历
        calendar.add(Calendar.YEAR, -beforeyear);
        calendar.add(Calendar.MONTH, -brforeMonth);
        calendar.add(Calendar.DAY_OF_MONTH, -beforeDay);
        dBefore = calendar.getTime(); //得到前90月的时间
        return dBefore;
    }


    /**
     * 获取月份的天数
     *
     * @param date
     * @return
     */
    public static Integer getMonthDayNum(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getActualMaximum(Calendar.DATE);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * 获取本月天数
     *
     * @return
     */
    public static Integer getThisMonthDayNum() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getActualMaximum(Calendar.DATE);
    }

    public static Date getBeginOfDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date begin = calendar.getTime();
        return begin;
    }

    public static Date getEndOfDate(Date date) {
        if (date == null) {
            return null;
        }
        Date begin = getBeginOfDate(date);
        return new Date(begin.getTime() + 24 * 60 * 60 * 1000 - 1);
    }
}

