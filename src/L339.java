import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L339 {
    /**
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
     */
    public static void main(String[] args) {

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                res[i] = -1.0;
            } else if (a.equals(b)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(graph, a, b, new HashMap<>());
            }
        }
        return res;


    }
    private double dfs(Map<String, Map<String, Double>> graph, String a, String b, Map<String, Double> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1.0;
        }
        if (a.equals(b)) {
            return 1.0;
        }
        if (visited.containsKey(a)) {
            return -1.0;
        }
        visited.put(a, 1.0);
        for (Map.Entry<String, Double> entry : graph.get(a).entrySet()) {
            double res = dfs(graph, entry.getKey(), b, visited);
            if (res != -1.0) {
                return res * entry.getValue();
            }
        }
        return -1.0;
    }
}
