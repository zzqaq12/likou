import java.util.Arrays;

public class L73 {
    // 73. 矩阵置零

    /**
     *
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     */

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] cow = new int[m];
        int[] row = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    cow[i] = 1;
                    row[j] = 1;
                }
            }
        }
        //每行设置为0
        for (int i = 0; i < m; i++) {
           if (cow[i] == 1) {
               for (int j = 0; j < n; j++) {
                   matrix[i][j] = 0;
               }
           }
        }
        //每列设置为0
        for (int j = 0; j < n; j++) {
            if (row[j] == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
