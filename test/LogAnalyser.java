package com.xhahn.test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: xhahn
 * Data: 2016/4/1/0001
 * Time: 10:47
 */
public class LogAnalyser {

    static String parseLog(String str) {

        /*
        * 正则表达式
        * \S表示非空字符
        * \d表示一个数字
        * {n}表示重复n次
        * []表示范围内的任一个， 如[\+\-]表示+或-，[A-Z]表示任一大写字母
        * a|b 表示a或b
        * ()表示分组，各个括号内的内容分成一组
        * 例子：
        * 待匹配字符：5614DAF
        * 正则表达式：(\d{4})([A-Z]{3})
        * 匹配结果：组1 “5614”， 组2 “DAF”
        */

        //1-105位的正则表达式    4位数字  6位非空字符 5位数字 8位数字  4位数字 1位数字或一位字母 正负5位数字     正负6位数字    5位非空字符   正负4位数字   5位非空字符 4位非空字符 3位数字 1位数字 9或者一位字母 4位数字 5位数字 一位数字 9或者一位字母 9或Y或N 6位数字 1位数字 9或N或V 1位数字 正负4位数字 1位非空 正负4位数字  一位非空 5位数字 1位数字
        final String base = "^(\\d{4})(\\S{6})(\\d{5})(\\d{8})(\\d{4})(\\d|[A-Z])([\\-\\+]\\d{5})([\\-\\+]\\d{6})(\\S{5})([\\-\\+]\\d{4})(\\S{5})(\\S{4})(\\d{3})(\\d)(9|[A-Z])(\\d{4})(\\d)(\\d{5})(\\d)(9|[A-Z])([9YN])(\\d{6})(\\d)([9NV])(\\d)([\\-\\+]\\d{4})(\\S)([\\-\\+]\\d{4})(\\S)(\\d{5})(\\d)";
        //106-  待补充
        final String add = "";

        String record = str;
        //用一个Pattern去编译正则表达式
        Pattern pattern = Pattern.compile(base);
        //用一个Matcher去匹配
        Matcher matcher = pattern.matcher(record);

        //如果没有匹配的，就返回一个特殊值
        if (!matcher.find()) {
            return "can not match";
        }

        /*
         * 这个时候就可以获得分割后的内容了
         * 第k组的内容，就是matcher.group(k)
         * 比如上面那个例子里
         * matcher.group(1)就是“5614”
         * matcher.group(2)就是“DAF”
         */

        //总共的组数
        int groupCount = matcher.groupCount();
        //打印所有的内容

        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= groupCount; i++) {
            //格式
            result.append(matcher.group(i) + " ");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        //path is the root directory,for example allData
        String rootPath = "src\\allData";
        File rootfile = new File(rootPath);
        //store all the files' name into a list called files
        String[] files = rootfile.list();
        System.out.println(files.length);

        String path2 = "F:\\out.txt";
        File file2 = new File(path2);
        BufferedWriter writer = null;

        try {
            //if the output file is not exist,create it
            if (!file2.exists()) {
                file2.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(file2));
            //for every file
            for (String filename : files) {
                File file = new File(rootPath + "\\" + filename);
                BufferedReader reader = null;

                //get a reader to read the file
                reader = new BufferedReader(new FileReader(file));

                String line = null;
                //read one line while the file is not null
                //one line a time
                while ((line = reader.readLine()) != null) {

                    String parsed = parseLog(line);
                    if (parsed == "can not match") {
                        System.out.println("[file matching failure] : " + filename);
                        break;
                    }

                    writer.write(parsed);
                    writer.newLine();

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

