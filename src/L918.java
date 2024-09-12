public class L918 {
    /**
     * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     *
     * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
     *
     * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
     */
    public static void main(String[] args) {

        L918 l918 = new L918();
        int[] nums = {1,-2,3,-2};
        System.out.println(l918.maxSubarraySumCircular(nums));
    }
    /**
     * 计算循环子数组的最大和
     * 这个函数考虑数组中的元素可以循环使用，即最后一个元素后面是第一个元素
     *
     * @param nums 输入的整数数组
     * @return 返回循环子数组的最大和
     */
    public int maxSubarraySumCircular(int[] nums) {
        // 初始化最大子数组和为第一个元素
        int maxSum = nums[0];
        // 用于累加当前子数组和的变量
        int curSum = 0;
        // 遍历数组，计算最大子数组和
        for (int num : nums) {
            curSum += num;
            // 更新最大子数组和
            maxSum = Math.max(maxSum, curSum);
            // 如果当前和小于0，重置为0
            curSum = Math.max(curSum, 0);
        }
        // 计算数组总和
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // 将数组最后一个元素置为0，以使用minSubArraySum方法计算最小子数组和
        nums[nums.length - 1] = 0;
        // 返回最大子数组和与总和减去最小子数组和的较大值
        return Math.max(maxSum, totalSum - minSubArraySum(nums));
    }

    /**
     * 计算非空子数组的最小和
     *
     * @param nums 输入的整数数组
     * @return 返回非空子数组的最小和
     */
    private int minSubArraySum(int[] nums) {
        // 初始化最小子数组和为第一个元素
        int minSum = nums[0];
        // 用于累加当前子数组和的变量
        int curSum = 0;
        // 遍历数组，计算最小子数组和
        for (int num : nums) {
            curSum += num;
            // 更新最小子数组和
            minSum = Math.min(minSum, curSum);
            // 如果当前和大于0，重置为0
            curSum = Math.min(curSum, 0);
        }
        // 返回最小子数组和
        return minSum;
    }
}

