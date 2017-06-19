package com.xhahn.test;

/**
 * User: xhahn
 * Data: 2015/11/2/0002
 * Time: 20:24
 */
public class TestPrivate {
    private String privateString = "i am private";

    public boolean equals(Object object){
        return object instanceof TestPrivate && privateString.equals(((TestPrivate) object).privateString);
    }
}
