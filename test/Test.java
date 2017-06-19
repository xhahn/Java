package com.xhahn.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: xhahn
 * Data: 2015/11/2/0002
 * Time: 20:26
 */
public class Test {

    static void testRand(){
        final int ranger = 100;
        int rand = (int)(Math.random()*ranger);
        System.out.println(rand);
    }


    static void testInitial(){
        TestInitial ti = new TestInitial();
        ti.func();
    }

    static void testLog(){
        double a = Math.log(0.0000213);
        double b = Math.log(0.00023);
        if(a+a<b+b)
            System.out.println("a"+a);
    }

    static void testPrivate(){
        TestPrivate tp = new TestPrivate();
        TestPrivate tp2 = new TestPrivate();
        System.out.println(tp.equals(tp2));
    }

    static void testPattern(){
        String line = "123s123";
        String rule = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }

    public enum turnRight {
        RIGHT(1,0), DOWN(0,1), LEFT(-1,0), UP(0,-1);

        private int x;
        private int y;

        private turnRight(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }
    static void testEnum() {

        final int COUNT = 10;

        for(int i=0;i<COUNT;i++){
            turnRight d = null;
            switch (i%4+1){
                case 1:d = turnRight.RIGHT;break;
                case 2:d = turnRight.DOWN;break;
                case 3:d = turnRight.LEFT;break;
                case 4:d = turnRight.UP;break;
            }
            System.out.println(i+":"+d.getX()+","+d.getY());
        }

    }

}
