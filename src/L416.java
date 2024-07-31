public class L416 {
    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     */
    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};
        System.out.println(new L416().canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp[i] 表示是否可以找到一个子集，其元素和为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                // 如果 dp[i] 为 true，说明可以找到一个子集，其元素和为 i，那么 dp[i - num] 也为 true
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];

    }
}
