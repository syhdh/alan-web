/**
 * ChangeLanguageAction.java
 * Created at 2017年4月13日
 * Created by FPM0218
 * Copyright (C) 2014-2017 FNConn, All rights reserved.
 */
package com.alan.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>ClassName: StringUtil</p>
 * <p>Description: StringUtil</p>
 * <p>Author: FPM0167</p>
 * <p>Date: 2017年4月25日</p>
 */
@SuppressWarnings("restriction")
public class StringUtil {
    /**
     * 空值
     */
    public static final String EMPTY = "";

    /**
     * <p>Description: map转logstring</p>
     * @param map map
     * @return string
     */
    public static String mapToLogInfo(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] splits = new String[] { "=", ";" };
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = removeSplit(entry.getKey(), splits);
            String value = removeSplit(entry.getValue(), splits);
            sb.append(key);
            sb.append(splits[0]);
            sb.append(value);
            sb.append(splits[1]);
        }
        return sb.toString();

    }

    /**
     * <p>Description: map转string</p>
     * @param map map对象
     * @param splits 分隔符
     * @return string
     */
    public static String mapToString(Map<String, String> map, String[] splits) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        if (splits == null || splits.length < 2) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = removeSplit(entry.getKey(), splits);
            String value = removeSplit(entry.getValue(), splits);
            sb.append(key);
            sb.append(splits[0]);
            sb.append(value);
            sb.append(splits[1]);
        }
        return sb.toString();

    }

    /**
     * <p>Description: 剔除字符串中指定字符</p>
     * @param source 源字符串
     * @param splits 需剔除字符
     * @return string
     */
    private static String removeSplit(String source, String[] splits) {
        if (source == null || source.trim().length() <= 0) {
            return null;
        }
        if (splits == null || splits.length <= 0) {
            return source;
        }
        for (String split : splits) {
            source = source.replaceAll(split, "");
        }
        return source;
    }

    /**
     * <p>Description: 获取uuid</p>
     * @return uuId
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
    }

    /**
     * <p>Description: Object转string</p>
     * @param obj 对象
     * @return string
     */
    public static String getString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * <p>Description: Object转string并去除空格</p>
     * @param obj 对象
     * @return string
     */
    public static String getStringTrim(Object obj) {
        return obj == null ? "" : obj.toString().trim();
    }

    /**
     * <p>Description: 判断是否为空 true 为空，false不为空</p>
     * @param obj string
     * @return 结果
     */
    public static boolean isEmpty(String obj) {
        return obj == null || obj.trim().length() == 0;
    }

    /**
     * <p>Description: 判断是否不为空， true不为空，false 为空</p>
     * @param obj string
     * @return 结果
     */
    public static boolean isNotEmpty(String obj) {
        return obj != null && obj.trim().length() > 0;
    }

    /**
     * <p>Description: 字符串转list数组</p>
     * @param str string
     * @param splitStr 分隔符
     * @return list
     */
    public static List<Long> toLongList(String str, String splitStr) {
        List<Long> list = new ArrayList<Long>();
        if (str != null) {
            String[] contents = str.split(splitStr);
            for (String content : contents) {
                if (content.trim().matches("\\d{1,19}")) {
                    list.add(Long.valueOf(content.trim()));
                }
            }
        }
        return list;
    }

    /**
     * <p>Description: 去除首位的0</p>
     * @param str string
     * @return string
     */
    public static String zeroSuppression(String str) {
        String newStr = null;
        if (!"0".equalsIgnoreCase(str)) {
            newStr = str.replaceAll("^(0+)", "");
            if (newStr == null || "".equalsIgnoreCase(newStr)) {
                newStr = "0";
            }
        } else {
            newStr = str;
        }
        return newStr;
    }

    /**
     * <p>Description: 去除特殊符号</p>
     * @param str string
     * @return string
     */
    public static String getValue(String str) {
        if (str == null) {
            return "";
        }
        String regEx = "[':<><//>\"]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }

    /**
     * 主要用来过滤非法字符，防止链接注入
     * 
     * @author ouyang
     * @param value 字符串
     * @return 过滤后结果
     */
    public static String filterIllegalString(String value) {
        if (value == null) {
            return null;
        }
        value = value.replaceAll("\\|", "");

        value = value.replaceAll("&", "&amp;");

        value = value.replaceAll(";", "");

        value = value.replaceAll("@", "");

        value = value.replaceAll("'", "");
        value = value.replaceAll("!--", "");

        value = value.replaceAll("\"", "");

        value = value.replaceAll("\\'", "");

        value = value.replaceAll("\\\"", "");

        value = value.replaceAll("<", "&lt;");

        value = value.replaceAll(">", "&gt;");

        value = value.replaceAll("\\(", "");

        value = value.replaceAll("\\)", "");

        value = value.replaceAll("\\+", "");

        value = value.replaceAll("\r", "");

        value = value.replaceAll("\n", "");

        value = value.replaceAll("script", "");

        value = value.replaceAll("%27", "");
        value = value.replaceAll("%22", "");
        value = value.replaceAll("%3E", "");
        value = value.replaceAll("%3C", "");
        value = value.replaceAll("%3D", "");
        value = value.replaceAll("%2F", "");
        value = value.replaceAll("%20", "");

        return value;
    }

    /**
     * 把字符串中strFrom替换成strTo
     * 
     * @param paramStrSource 输入字串
     *            
     * @param strFrom 要被替换是字符串
     *            
     * @param strTo 替换字符
     *            
     * @return 替换成功后的字符串
     */
    public static String replace(String paramStrSource, String strFrom, String strTo) {
        String strSource = paramStrSource;
        StringBuffer strDest = new StringBuffer("");
        int intFromLen = strFrom.length();
        int intPos;

        while ((intPos = strSource.indexOf(strFrom)) != -1) {
            strDest.append(strSource.substring(0, intPos));
            strDest.append(strTo);
            strSource = strSource.substring(intPos + intFromLen);
        }
        strDest.append(strSource);

        return strDest.toString();
    }

    public static String getSpaceString() {
        return " ";
    }
    /*2018/02/24 add by FPM0288 for 20180129008 start*/
    /**
     * <p>Description: 字符串类型数字转Double，并保留2位小数</p>
     * @param obj obj
     * @return Double
     */
    public static Double objToDouble(Object obj) {
        BigDecimal bigDecimal = new BigDecimal(obj.toString());
        return Double.parseDouble(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }
    /*2018/02/24 add by FPM0288 for 20180129008 end*/
    
    /**
     * <p>Description: 字符串类型数字转BigDecimal，并保留2位小数</p>
     * @param obj obj
     * @return BigDecimal
     */
    public static BigDecimal objToBigDecimal(Object obj) {
        BigDecimal bigDecimal = new BigDecimal(obj.toString());
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * <p>Description: BASE64编码</p>
     * @param str 
     * @return String
     */
    public static String encode(String str) {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * <p>Description: BASE64解码</p>
     * @param str 
     * @return String
     */
    public static String decode(String str) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(str), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    
	/** 十六进制下数字到字符的映射数组 */
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
     * 对字符串进行MD5编码
     * @param originString
     * @return
     */
    public static String encodeByMD5(String originString) {
        if (originString != null){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(originString .getBytes());
                String resultString = byteArrayToHexString(results);
                return resultString;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    /**
     * 转换字节数组为16进制字串
     * 
     * @param b  字节数组
     * @return 十六进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    
    /**
     * 将一个字节转化成16进制形式的字符串
     * @param b
     * @return
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
    
    public static String toUTF8(String str) {
    	if (isEmpty(str)) {
    		return "";
    	}
    	try {
    		if (str.equals(new String(str.getBytes("GB2312"), "GB2312"))) {
    			str = new String(str.getBytes("GB2312"), "utf-8");
    			return str;
    		}
    	} catch (Exception exception) {
    	}
    	try {
    		if (str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))) {
    			str = new String(str.getBytes("ISO-8859-1"), "utf-8");
    			return str;
    		}
    	} catch (Exception exception1) {
    	}
    	try {
    		if (str.equals(new String(str.getBytes("GBK"), "GBK"))) {
    			str = new String(str.getBytes("GBK"), "utf-8");
    			return str;
    		}
    	} catch (Exception exception3) {
    	}
    	return str;
    }


}

/**
* Revision History
* -------------------------------------------------------------------------
* Version       Date             Author          Note
* -------------------------------------------------------------------------
* 1.1.0     2017年12月26日                      FPM0218     
* 1.1.1     2018年03月20日                FPM0167         添加string转数字保存2位小数方法
*/




