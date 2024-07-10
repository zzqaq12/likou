import java.util.ArrayList;
import java.util.List;

public class L228 {
    /**
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     *
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     *
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     */
    public static void main(String[] args) {

        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                list.add(start + "->" + nums[i]);
            } else {
                list.add(start + "");
            }
        }
        return list;

    }
}
