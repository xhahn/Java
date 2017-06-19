package com.xhahn.test.jianzhi._8;

/**
 * User: xhahn
 * Data: 2016/7/7/0007
 * Time: 18:50
 */
public class PathFinder {

    static char[][] matrix = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
    static boolean[][] visited = new boolean[3][4];

    boolean findPath(char[][] matrix, boolean[][] visited,int startX, int startY, String path){

        if (path.equals(""))
            return true;

        if (startX<0 || startY<0 || startX>=matrix.length || startY>= matrix[0].length || matrix[startX][startY] != path.charAt(0) || visited[startX][startY] == true){
            return false;
        }

        visited[startX][startY] = true;

        return findPath(matrix, visited, startX+1, startY, path.substring(1))
                || findPath(matrix, visited, startX-1, startY, path.substring(1))
                || findPath(matrix, visited, startX, startY+1, path.substring(1))
                || findPath(matrix, visited, startX, startY-1, path.substring(1));

    }

    public static void main(String[] args) {
        PathFinder finder = new PathFinder();
        System.out.println();

        String path = "bcced";

        for (int i=0;i<matrix.length-1;i++)
            for (int j=0;j<matrix[0].length-1;j++){
                if (matrix[i][j] == path.charAt(0)) {
                    if (finder.findPath(matrix, visited, i, j,path)){
                        System.out.println("true "+i+" "+j);
                        break;
                    }
                }
            }
    }
}
