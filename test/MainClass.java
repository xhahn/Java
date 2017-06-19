package com.xhahn.test;

import java.util.*;

/**
 * User: xhahn
 * Data: 2015/10/24/0024
 * Time: 16:20
 */

public class MainClass {

    public void modify(int[] a){
        a[0] = 123;
    }

    public int func()
    {
        int count = 0;
        int num = 12345;
        while (num != 0)
        {
            count++;
            num &= (num - 1);
        }
        return count;
    }


    public static void main(String[] args) {

        String ssss = "122.205.9.67";
        System.out.println("------------------------"+ssss.split("\\.").length);

        Map<Character,Integer> map = new HashMap<>();

        Object o = new Float(0.15F);
        Object os[] = new Object[1];
        os[0] = o;
        o=null;
        System.out.println(os[0]);

        System.out.println("23".compareTo("231"));
        MainClass main = new MainClass();
        System.out.println(main.func()+"  dasfa a");
        StringBuilder sb = new StringBuilder();

        char ch = '4';
        System.out.println(ch - 48);

        Queue<String> queue = new LinkedList<String>();
        queue.isEmpty();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");

        Collections.sort(list);
        System.out.println(list);

        Scanner scanner = new Scanner(System.in);
        int test = 0;

        String a = "hello";
        String b = a + 2;
        final String d = "hello";
        String e = d + 2;
        String c = "hello2";
        System.out.println(b);

        System.out.println(b == c);
        System.out.println(e == c);
        String tests = "ahjSSSs";
        String[] s = tests.split("[A-Z]");
        System.out.println("s length:"+s.length);
        for(String ss : s){
            System.out.println(ss+",");
            System.out.println(ss.equals(""));
        }
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("**********java test**********");
            System.out.println("0:quit");
            System.out.println("1:TestInitial");
            System.out.println("2:TestLog");
            System.out.println("3:TestPrivate");
            System.out.println("4:TestPattern");
            System.out.println("5:TestRandom");
            System.out.println("6:TestEnum");
            System.out.print("which one do you want to test: ");
            test = scanner.nextInt();
            System.out.println("*****************************");

            switch (test) {

                case 1:
                    Test.testInitial();
                    break;

                case 2:
                    Test.testLog();
                    break;

                case 3:
                    Test.testPrivate();
                    break;

                case 4:
                    Test.testPattern();
                    break;

                case 5:
                    Test.testRand();
                    break;

                case 6:
                    Test.testEnum();
                    break;

                case 0: return;

                default:
                    System.out.println("please choose a number listed");
                    continue;
            }
        }
    }
}