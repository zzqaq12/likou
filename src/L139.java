import java.util.Arrays;
import java.util.List;

public class L139 {
    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     *
     */
    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s,wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // dp[i] 表示 s[0,i] 是否能被拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
