import java.util.HashMap;
import java.util.Map;

public class BD1 {
    /**
     * 找到字符串中，重复字符不超过K个的最长子串
     * 输入：str = deceeeebbbba k=2
     * 输出：eeeebbbb
     */
    public static void main(String[] args) {

        String s = "deceba";
        System.out.println(longestSubstring(s, 2));
    }

    public static String longestSubstring(String str, int k) {

        if (str == null || str.length() == 0 || k <= 0) {
            return "";
        }
        // 统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // 滑动窗口的左边界
        int maxLength = 0; // 最长子串的长度
        String longestSubstring = ""; // 最长子串
        for (int right = 0; right < str.length(); right++) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
            // 如果窗口中字符的个数大于k，移动左边界
            while (map.size() > k) {
                map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
                // 如果移除后，窗口中字符的个数小于k，则窗口左边界向右移动
                if (map.get(str.charAt(left)) == 0) {
                    map.remove(str.charAt(left));

                }
                // 更新最长子串的长度和子串
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    longestSubstring = str.substring(left, right);
                }
                left++;


            }
        }
        return longestSubstring;
    }

}
