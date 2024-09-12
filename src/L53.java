public class L53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组
     * 是数组中的一个连续部分。
     */
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        L53 l53 = new L53();
        System.out.println(l53.maxSubArray(nums));
    }
    /**
     * 寻找数组中最大的连续子数组和
     *
     * @param nums 整数数组，可以包含负数和正数
     * @return 返回最大的连续子数组和
     */
//    public int maxSubArray(int[] nums) {
//        // 初始化最大子数组和为数组第一个元素
//        int max = nums[0];
//        // 用于计算当前子数组的和
//        int sum = 0;
//        for (int num : nums) {
//            // 如果当前子数组和大于0，则将当前元素加入到子数组和中
//            if (sum > 0) {
//                sum += num;
//            } else {
//                // 如果当前子数组和小于等于0，则从当前元素开始重新计算子数组和
//                sum = num;
//            }
//            // 更新最大子数组和
//            max = Math.max(max, sum);
//        }
//        // 返回最大子数组和
//        return max;
//    }

    // 分治法
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid + 1, right);
        int crossMax = cross(nums, left, mid, right);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int cross(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
