public class L200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
   }
   public void dfs(char[][] grid, int i, int j) {
       if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
           return;
       }
       // 标记
       grid[i][j] = '2';
       dfs(grid, i + 1, j);
       dfs(grid, i - 1, j);
       dfs(grid, i, j + 1);
       dfs(grid, i, j - 1);
   }
}
