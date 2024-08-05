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

    public static String longestSubstring(String s, int k) {

        if (s == null || s.length() == 0 || k <= 0) {
            return "";
        }

        // 统计每个字符出现的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (right < chars.length) {
            // 如果当前字符的个数大于等于k，则右指针右移
            if (count[chars[right] - 'a'] >= k) {
                right++;
            } else {
                if (right - left > maxLen) {
                    maxLen = right - left;
                    maxLeft = left;
                    maxRight = right;
                }
                // 当前字符的个数小于k，则左指针右移
                left = right + 1;
                right++;
            }
        }

        if (right - left > maxLen) {
            maxLen = right - left;
            maxLeft = left;
            maxRight = right;
        }

        return s.substring(maxLeft, maxRight);

    }
}
