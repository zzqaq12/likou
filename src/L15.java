public class L15 {
    /**
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
     *
     *
     */
    public static void main(String[] args) {
        int i = new L15().totalNQueens(4);
        System.out.println(i);

    }

    private int count = 0;
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        placeQueen(queens, 1, n);
        return count;
    }
    private void placeQueen(int[] queens, int row, int n) {
        if (row > n) {
            count++;
            for (int i = 0; i < n; i++) {
                System.out.print(queens[i] + " ");
            }
            System.out.println();
            return;

        }
        //queens[i] 获取第 i 行上的皇后所在的列号。
        for (int col = 1; col <= n; col++) {
            if (isValid(queens, row, col)) {
                queens[row - 1] = col;
                placeQueen(queens, row + 1, n);
            }
        }
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 1; i < row; i++) {
            //queens[i] == col，则意味着两皇后在同一列
            //Math.abs(state[i] - col) == Math.abs(i - row)，则意味着两皇后在同一对角线上
            if (queens[i - 1] == col || Math.abs(row - i) == Math.abs(col - queens[i - 1])) {
                return false;
            }
        }
        return true;
    }


}
