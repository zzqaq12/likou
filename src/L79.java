public class L79 {
    /**
     *给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new L79().exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        // 如果已经匹配到最后一个字符，说明找到了一个匹配：
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if (dfs(board, word, index + 1, i - 1, j, visited) ||
                dfs(board, word, index + 1, i + 1, j, visited) ||
                dfs(board, word, index + 1, i, j - 1, visited) ||
                dfs(board, word, index + 1, i, j + 1, visited)) {
            return true;
        }
        // 回溯：撤销标记，以便后续搜索可以再次访问这个格子：
        visited[i][j] = false;
        return false;
    }
}
