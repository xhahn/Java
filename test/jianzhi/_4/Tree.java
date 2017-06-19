package com.xhahn.test.jianzhi._4;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xhahn
 * Data: 2016/7/1/0001
 * Time: 17:56
 */
class BTreeNode{
    int value;
    BTreeNode left = null;
    BTreeNode right = null;
}

public class Tree {
    private static BTreeNode root = new BTreeNode();
    static
    {
        root.value = 10;
        root.left = new BTreeNode();
        root.right = new BTreeNode();
        BTreeNode node;
        root.right.value = 12;
        node = root.left;
        node.value = 5;
        node.left = new BTreeNode();
        node.right = new BTreeNode();
        node.left.value = 4;
        node.right.value = 7;
    }

    void printPath(BTreeNode root, int n, List<Integer> path){

        path.add(root.value);
        n -= root.value;

        if (n == 0 && root.left == null && root.right == null){
            for (Integer i : path){
                System.out.print(i + " ");
            }
            System.out.println();
            path.remove(path.indexOf(root.value));
            return;
        }

        if (root.left != null)
            printPath(root.left, n, path);
        if (root.right != null)
            printPath(root.right, n, path);

        //n += root.value;
        path.remove(path.indexOf(root.value));
        return;
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.printPath(root, 22, new ArrayList<Integer>());
    }
}
