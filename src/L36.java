public class L36 {
    // 36. 有效的数独

    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *
     *
     * 注意：
     *
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用 '.' 表示。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static boolean isValidSudoku(char[][] board) {
        int [][] rows = new int[9][9];
        int [][] cols = new int[9][9];
        int [][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num]++;
                    cols[j][num]++;
                    boxes[i / 3][j / 3][num]++;
                    if (rows[i][num] > 1 || cols[j][num] > 1 || boxes[i / 3][j / 3][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}