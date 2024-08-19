import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     */
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new L39().combinationSum(candidates, target));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, target, 0, res);
        return res;
    }
    /**
     * 使用深度优先搜索（DFS）查找所有满足给定条件的组合
     *
     * @param candidates 候选数字数组
     * @param target 目标和
     * @param start 当前搜索的起始位置
     * @param res 保存所有满足条件的组合
     */
    public void dfs(List<Integer> state, int[] candidates, int target, int start, List<List<Integer>> res) {

        // 当目标和为0时，找到了一个满足条件的组合
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历候选数字数组
        for (int i = start; i < candidates.length; i++) {
            // 如果当前数字大于目标和，跳过
            if (candidates[i] > target) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(candidates[i]);
            // 进行下一轮选择
            dfs(state, candidates,target - candidates[i], i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

}
