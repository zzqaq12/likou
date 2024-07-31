import java.util.PriorityQueue;

public class L245 {
    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *
     */
    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.poll();
    }
}
