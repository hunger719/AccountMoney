package com.aacount.hunger.aacountmoney.util;

import android.content.Context;
import android.widget.Toast;

import java.math.BigDecimal;

/**
 * Created by ChenHan on 2017-4-19.
 */

public class Util {

    private static Toast toast = null;

    /**
     * 弹出一个自定义吐司
     * @param c
     * @param s
     */
    public static void showToast(Context c, String s)
    { if (null == toast)
        {
            toast = Toast.makeText(c, s, Toast.LENGTH_SHORT);
        }
        else
        {
            toast.setText(s);
        }
        toast.show();
    }

    /**
     * * 两个Double数相加 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double add(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.add(b2).doubleValue());
    }

    /**
     * * 两个Double数相减 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.subtract(b2).doubleValue());
    }

    /**
     * * 两个Double数相乘 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double mul(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.multiply(b2).doubleValue());
    }

    /**
     * * 两个Double数相除 *
     *
     * @param v1 *
     * @param v2 *
     * @return Double
     */
    public static Double div(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return new Double(b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP)
                .doubleValue());
    }

    /**
     * 从尾部开始删除字符的方法
     * @param origin
     * @param count
     * @return
     */
    public static String subString(String origin, int count) {
        if (origin == null || origin.length() < count) {
            return null;
        }
        char[] arr = origin.toCharArray();
        char[] ret = new char[arr.length - count + 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr[i];
        }
        return String.copyValueOf(ret);
    }
}
