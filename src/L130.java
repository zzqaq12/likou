public class L130 {
    /**
     * 给你一个 m O n 的矩阵 board ，由若干字符 'O' 和 'O' 组成，捕获 所有 被围绕的区域：
     *
     * 连接：一个单元格与水平或垂直方向上相邻的单元格连接。
     * 区域：连接所有 'O' 的单元格来形成一个区域。
     * 围绕：如果您可以用 'O' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'O' 单元格围绕。
     * 通过将输入矩阵 board 中的所有 'O' 替换为 'O' 来 捕获被围绕的区域。
     */
    public static void main(String[] args) {

        char[][] board = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
//    public static void solve(char[][] board) {
//        int m = board.length;
//        int n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == 'O') {
//                    if (i != 0 && i != m - 1 && j != 0 && j != n - 1) {
//                        dfs(board, i, j);
//                    }
//                }
//            }
//        }
//
//
//    }
//    public static void dfs(char[][] board, int i, int j) {
//        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1 || board[i][j] != 'O') {
//            return;
//        }
//        board[i][j] = 'X';
//        dfs(board, i - 1, j);
//        dfs(board, i + 1, j);
//        dfs(board, i, j - 1);
//        dfs(board, i, j + 1);
//    }
public static void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length <= 2) return;

    int m = board.length;
    int n = board[0].length;

    // 首先处理边界上的 'O' 及其相连的 'O'，并标记它们
    for (int i = 0; i < m; i++) {
        dfs(board, i, 0); // 左边界
        dfs(board, i, n - 1); // 右边界
    }
    for (int j = 0; j < n; j++) {
        dfs(board, 0, j); // 上边界
        dfs(board, m - 1, j); // 下边界
    }

    // 再次遍历整个矩阵，将未被标记的 'O' 替换成 'X'，已标记的 'O' 恢复为 'O'
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'O') {
                board[i][j] = 'X'; // 将未标记的 'O' 替换成 'X'
            } else if (board[i][j] == '#') {
                board[i][j] = 'O'; // 将标记过的 'O' 恢复为 'O'
            }
        }
    }
}

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#'; // 使用 '#' 标记已经访问过的 'O'
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
