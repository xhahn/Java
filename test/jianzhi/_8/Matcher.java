package com.xhahn.test.jianzhi._8;

/**
 * User: xhahn
 * Data: 2016/7/6/0006
 * Time: 11:26
 */
public class Matcher {

    boolean match(String str, String pattern){
        if (str.equals("") && pattern.equals(""))
            return true;
        else if (str.equals("") || pattern.equals(""))
            return false;

        if (pattern.length() > 1) {
            if (pattern.charAt(1) == '*') {
                if (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.') {
                    return match(str.substring(1), pattern)
                            || match(str.substring(1), pattern.substring(2));
                } else {
                    return match(str, pattern.substring(2));
                }
            }
        }

        if (pattern.charAt(0) == '.' || str.charAt(0) == pattern.charAt(0))
            return match(str.substring(1), pattern.substring(1));

        return false;
    }

    public static void main(String[] args) {
        Matcher matcher = new Matcher();
        System.out.println(matcher.match("aaa", "aa.a"));
    }
}
