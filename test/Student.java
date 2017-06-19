package com.xhahn.test;

/**
 * User: xhahn
 * Data: 2016/4/20/0020
 * Time: 21:59
 */
public class Student implements doJob
{
    private String name = null;
    int n[] = {1,2,3,4,5,6};

    public Student(String name)
    {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void fillBlank(int a, int b, int result)
    {
        // TODO Auto-generated method stub
        System.out.println(name + "«Û÷˙–°∫Ïº∆À„:" + a + " + " + b + " = " + result);
    }

    public void callHelp (int a, int b)
    {
        new SuperCalculator().add(a, b, this);
    }
}