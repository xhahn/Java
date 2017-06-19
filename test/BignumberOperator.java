package com.xhahn.test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xhahn
 * Data: 2016/4/18/0018
 * Time: 21:58
 */
public class BignumberOperator {
    public String m_multiply(String num1, int num2){
        System.out.println(num1+","+num2);
        StringBuilder answer = new StringBuilder();
        int length = num1.length();
        int carry = 0;
        for(int i=length-1;i>=0;i--){
            int multiply = (num1.charAt(i) - 48) * num2  + carry;
            answer.append(multiply % 10);
            carry = multiply / 10;
        }
        if (0 != carry)
            answer.append(carry);
        return answer.reverse().toString();
    }

    public String m_sum(String num1, String num2){
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        if (num1.length() < num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int length1 = num1.length();
        int length2 = num2.length();

        for(int i = length1-1,j = length2-1;j>=0;i--,j--){
            int sum = (num1.charAt(i) - 48) + (num2.charAt(j) - 48) + carry;
            answer.append(sum % 10);
            carry = sum / 10;
        }
        int i=length1-length2-1;
        for(;i>=0&&carry!=0;i--){
            int sum = num1.charAt(i) - 48 + carry;
            carry = sum / 10;
            answer.append(sum % 10);
        }
        if (0 != carry)
            answer.append(carry);
        return num1.substring(0,i+1) + answer.reverse().toString();

    }
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()){
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int length2 = num2.length();
        if (1 == length2 && num2.equals("0"))
            return "0";
        List<String> sums = new ArrayList<>();
        String zeros = "";
        for(int i=length2-1;i>=0;i--){
            sums.add(m_multiply(num1, num2.charAt(i)-48)+zeros);
            zeros += "0";
        }
        System.out.println(sums+" sums");
        String sum = "";
        for(String num : sums){
            sum = m_sum(sum, num);
            System.out.println(sum+",");
        }
        return sum;
    }

    public static void main(String[] args) {
        BignumberOperator operator = new BignumberOperator();
        operator.multiply("123456789","987654321");
    }
}
