import java.util.*;
import java.io.*;

Class LeetCode329{
	private int longestPath = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                findPath(i, j, matrix, 0, matrix[i][j]-1);//matrix[i][j]+1相当于负无穷
            }
        }
        return longestPath;
    }
    private void findPath(int i, int j, int[][] matrix, int pathLength, int last){
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) return;
        if(matrix[i][j] <= last) return;
        pathLength++;
        last = matrix[i][j];
        longestPath = Math.max(longestPath, pathLength);
        
        findPath(i-1, j, matrix, pathLength, last);
        findPath(i+1, j, matrix, pathLength, last);
        findPath(i, j-1, matrix, pathLength, last);
        findPath(i, j+1, matrix, pathLength, last);
    }
}