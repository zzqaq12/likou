import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class L373 {
    /**
     * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
     *
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
     *
     * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
     */
    public static void main(String[] args) {

        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 3;
        L373 l = new L373();
        List<List<Integer>> res = l.kSmallestPairs(nums1,nums2,2);
        for (List<Integer> list : res) {
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 创建优先队列
        if (k < nums1.length * nums2.length)

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]+b[1]) - (a[0]+a[1]));
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (pq.size() < k) {
                    pq.offer(new int[]{nums1[i],nums2[j]});
                } else {
                    // 如果队列满了，则比较当前元素和队列中最小的元素，如果当前元素小于队列中最小的元素，则替换队列中最小的元素
                    if (nums1[i] + nums2[j] < pq.peek()[0] + pq.peek()[1]) {
                       pq.poll();
                       pq.offer(new int[]{nums1[i],nums2[j]});
                   }
               }
           }
       }
       //添加到结果集
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            List<Integer> taskList = new ArrayList<>();
            taskList.add(task[0]); // 添加紧急度
            taskList.add(task[1]); // 添加重要度
            res.add(taskList);
        }
        return res;
    }
}
