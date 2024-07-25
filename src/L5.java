public class L5 {
    /**
     * 给你一个字符串 s，找到 s 中最长的
     * 回文
     *
     * 子串
     * 。
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        // 记录最长回文串的起始位置和长度
        int begin = 0;
        // 初始化dp
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 每个字符都是回文串
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    // 如果两个字符不相等，则不是回文串
                    dp[i][j] = false;
                } else {
                    // 如果两个字符相等，则需要判断是否是回文串
                    if (j - i < 3) {
                        // 如果两个字符相等，并且长度小于等于3，则直接判断为回文串
                        dp[i][j] = true;
                    } else {
                        // 如果两个字符相等，并且长度大于3，则需要判断是否是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
