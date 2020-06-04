package com.userqiao.crm.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author userqiao
 * @date 2020/06/04
 */
public class PinyinUtil {
    /**名字长度*/
    private static int NAME_LENGTH = 3;

    /**
     * 将汉字转换为全拼
     */
    public static String getPingYin(String src) {

        char[] name = src.toCharArray();
        String[] newName = new String[name.length];
        HanyuPinyinOutputFormat pyFormat = new HanyuPinyinOutputFormat();
        pyFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        pyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        pyFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        String account = "";
        int length = name.length;
        try {
            // 名字大于等于3个字的时候，姓取全称,名取首字母。
            if (length >= NAME_LENGTH) {
                for (int i = 0; i < length; i++) {
                    // 截取姓
                    if (i == 0) {
                        // 判断是否为汉字字符
                        if (Character.toString(name[i]).matches("[\\u4E00-\\u9FA5]+")) {
                            newName = PinyinHelper.toHanyuPinyinStringArray(name[i], pyFormat);
                            account += newName[0];
                        } else {
                            account += Character.toString(name[i]);
                        }
                    } else {
                        account += getPinYinHeadChar(Character.toString(name[i]));
                    }

                }
            } else {
                // 只有2个字的名字,账号是名字的拼音全称
                for (int i = 0; i < length; i++) {
                    // 判断是否为汉字字符
                    if (Character.toString(name[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        newName = PinyinHelper.toHanyuPinyinStringArray(name[i], pyFormat);
                        account += newName[0];
                    } else {
                        account += Character.toString(name[i]);
                    }
                }
            }
            return account;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return account;
    }


    /**
     * 返回中文的首字母
     * @param str 字符串
     * @return 首字母
     */
    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }


}
