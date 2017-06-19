package com.xhahn.test;


import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String[] result = {"invalid", "forward", "backward", "both"};
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            int flag = 0;

            int index1 = s.indexOf(s1);
            int index2 = s.indexOf(s2,index1+s1.length());

            StringBuilder sb = new StringBuilder(s);
            String ns = sb.reverse().toString();

            int index11 = ns.indexOf(s1);
            int index22 = ns.indexOf(s2,index11+s1.length());

            if (index1 != -1 && index2 != -1 && index11 != -1 && index22 != -1)
                flag = 3;
            else if (index1 != -1 && index2 != -1 )
                flag = 1;
            else if (index11 != -1 && index22 != -1 )
                flag = 2;

            System.out.printf("%s", result[flag]);
        }
    }
}
