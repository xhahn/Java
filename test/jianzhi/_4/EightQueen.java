package com.xhahn.test.jianzhi._4;

/**
 * User: xhahn
 * Data: 2016/7/2/0002
 * Time: 14:14
 */
public class EightQueen {

    static int[] position = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    static int count = 0;

    void findPositon(int[] position, int index) {
        if (index == 7) {
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 8; j++) {
                    if (i - j == position[i] - position[j] || i - j == position[j] - position[i]) {
                        return;
                    }
                }
            }
            for (int i : position) {
                System.out.print(i + " ");
            }
            count++;
            System.out.println();
            return;
        }
        for (int i = index;i<8;i++){
            int tmp = position[index];
            position[index] = position[i];
            position[i] = tmp;

            findPositon(position, index + 1);

            tmp = position[index];
            position[index] = position[i];
            position[i] = tmp;
        }

    }

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.findPositon(position, 0);
        System.out.println(count);
    }
}
