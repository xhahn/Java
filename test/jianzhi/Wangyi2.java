package com.xhahn.test.jianzhi;


import java.util.*;

class Node {
    Node left = null;
    Node right = null;
    String val = null;

    public Node() {
    }

    public Node(String val) {
        this.val = val;
    }
}

public class Wangyi2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String bitsStream = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        Node root = new Node();

        for (int i = 0; i < n - 2; i++) {
            String[] line = in.nextLine().split(" ");
            String s = line[0];
            String code = line[1];
            Node node = root;
            for (int j = 0; j < code.length() - 1; j++) {
                if (code.charAt(j) == '0') {
                    if (node.left == null) {
                        node.left = new Node();
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new Node();
                    }
                    node = node.right;
                }
            }
            if (code.charAt(code.length() - 1) == '0') {
                node.left = new Node(s);
            } else {
                node.right = new Node(s);
            }
        }

        String[] miss = new String[2];
        miss[0] = in.nextLine().split(" ")[0];
        miss[1] = in.nextLine().split(" ")[0];

        Node node = root;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringBuilder out = new StringBuilder();
            boolean flag = true;
            boolean flag2 = false;
            node = root;
            flag2 = false;
            for (int j = 0; j < bitsStream.length(); j++) {
                flag2 = false;
                if  (node.val == null) {
                    if (bitsStream.charAt(j) == '0') {
                        if (node.left == null) {
                            out.append(miss[i]);
                            flag2 = true;
                            node = root;
                        } else
                            node = node.left;
                    } else if (bitsStream.charAt(j) == '1') {
                            if (node.right == null) {
                                out.append(miss[1 - i]);
                                flag2 = true;
                                node = root;
                            } else
                                node = node.right;
                        }

                }
                else {
                    out.append(node.val);
                    node = root;
                    if (j!=bitsStream.length()-1)
                        j--;
                }
            }

            if (node.val != null)
                out.append(node.val);
            if (flag2 == false && node.val == null)
                flag = false;
            if (flag)
                result.add(out.toString());
        }

        Collections.sort(result);
        for (String s: result)
            System.out.println(s);
    }
}
