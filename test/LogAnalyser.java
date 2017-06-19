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
        * ������ʽ
        * \S��ʾ�ǿ��ַ�
        * \d��ʾһ������
        * {n}��ʾ�ظ�n��
        * []��ʾ��Χ�ڵ���һ���� ��[\+\-]��ʾ+��-��[A-Z]��ʾ��һ��д��ĸ
        * a|b ��ʾa��b
        * ()��ʾ���飬���������ڵ����ݷֳ�һ��
        * ���ӣ�
        * ��ƥ���ַ���5614DAF
        * ������ʽ��(\d{4})([A-Z]{3})
        * ƥ��������1 ��5614���� ��2 ��DAF��
        */

        //1-105λ��������ʽ    4λ����  6λ�ǿ��ַ� 5λ���� 8λ����  4λ���� 1λ���ֻ�һλ��ĸ ����5λ����     ����6λ����    5λ�ǿ��ַ�   ����4λ����   5λ�ǿ��ַ� 4λ�ǿ��ַ� 3λ���� 1λ���� 9����һλ��ĸ 4λ���� 5λ���� һλ���� 9����һλ��ĸ 9��Y��N 6λ���� 1λ���� 9��N��V 1λ���� ����4λ���� 1λ�ǿ� ����4λ����  һλ�ǿ� 5λ���� 1λ����
        final String base = "^(\\d{4})(\\S{6})(\\d{5})(\\d{8})(\\d{4})(\\d|[A-Z])([\\-\\+]\\d{5})([\\-\\+]\\d{6})(\\S{5})([\\-\\+]\\d{4})(\\S{5})(\\S{4})(\\d{3})(\\d)(9|[A-Z])(\\d{4})(\\d)(\\d{5})(\\d)(9|[A-Z])([9YN])(\\d{6})(\\d)([9NV])(\\d)([\\-\\+]\\d{4})(\\S)([\\-\\+]\\d{4})(\\S)(\\d{5})(\\d)";
        //106-  ������
        final String add = "";

        String record = str;
        //��һ��Patternȥ����������ʽ
        Pattern pattern = Pattern.compile(base);
        //��һ��Matcherȥƥ��
        Matcher matcher = pattern.matcher(record);

        //���û��ƥ��ģ��ͷ���һ������ֵ
        if (!matcher.find()) {
            return "can not match";
        }

        /*
         * ���ʱ��Ϳ��Ի�÷ָ���������
         * ��k������ݣ�����matcher.group(k)
         * ���������Ǹ�������
         * matcher.group(1)���ǡ�5614��
         * matcher.group(2)���ǡ�DAF��
         */

        //�ܹ�������
        int groupCount = matcher.groupCount();
        //��ӡ���е�����

        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= groupCount; i++) {
            //��ʽ
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

