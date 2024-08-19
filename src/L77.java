import java.util.ArrayList;
import java.util.List;

public class L77 {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *
     * 你可以按 任何顺序 返回答案。
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> combine = new L77().combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int i, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(path);
            return;
        }

        for (int j = i; j <= n; j++) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(j);
            dfs(n, k, j + 1, newPath, res);
        }
    }
}
 