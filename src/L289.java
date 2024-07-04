public class L289 {
    /**
     * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
     *
     * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     *
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
     * @param args
     */
    public static void main(String[] args) {
        int board[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
    }
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        //计算每个格子周围的活细胞数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                //遍历每个格子的周围8个格子
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) {
                            continue;
                        }
                        if (i + k >= 0 && i + k < m && j + l >= 0 && j + l < n) {
                            if (board[i + k][j + l] == 1) {
                                count++;
                            }
                        }
                    }
                }
                temp[i][j] = count;
            }
        }
        //根据规则更新每个格子的状态
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (temp[i][j] < 2) {
                        board[i][j] = 0;
                    } else if (temp[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (temp[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
