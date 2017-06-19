package com.xhahn.test;

/**
 * User: xhahn
 * Data: 2016/4/20/0020
 * Time: 21:58
 */
public class Seller implements doJob{
    private String name = null;

    public Seller(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void fillBlank(int a, int b, int result) {
        // TODO Auto-generated method stub
        System.out.println(name + "«Û÷˙–°∫ÏÀ„’À:" + a + " + " + b + " = " + result + "‘™");
    }


    public void callHelp (int a, int b)
    {
        new SuperCalculator().add(a, b, this);
    }

}