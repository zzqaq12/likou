import java.util.ArrayList;
import java.util.List;

public class L46 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(new L46().permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,0, res);
        return res;
    }

    public void dfs(int[] nums, int n, List<List<Integer>> list) {
        // 基本情况：当所有元素都已排列好时，将当前排列加入结果集
        if (n == nums.length - 1) {
            list.add(new ArrayList<>(nums.length));
            for (int num : nums)
                list.get(list.size() - 1).add(num);
            return;
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, n, i);
            dfs(nums, n + 1, list);
            // 撤销交换操作，这是回溯的关键步骤
            swap(nums, n, i);
        }
    }
    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
