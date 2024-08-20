import java.util.ArrayList;
import java.util.List;

public class L22 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public static void main(String[] args) {

        List<String> res = new L22().generateParenthesis(3);
        System.out.println(res);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "", 0, 0, n);
        return res;
    }
    private void dfs(List<String> res, String s, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            dfs(res, s + "(", left + 1, right, n);
        }
        if (right < left) {
            dfs(res, s + ")", left, right + 1, n);
        }
    }
}
