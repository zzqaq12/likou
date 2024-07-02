import java.util.ArrayList;
import java.util.List;

public class L54 {
    //54 螺旋矩阵
    public static void main(String[] args) {

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int rol = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        // 螺旋矩阵
        int left = 0;
        int right = rol - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return list;

    }

}
