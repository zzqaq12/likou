import java.util.HashMap;

public class L219 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
     * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
     */
    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 1};
        System.out.println(new L219().containsNearbyDuplicate(nums, 1));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (i - hashMap.get(nums[i]) <= k) {
                    return true;
                }
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }
}
