public class L290 {
    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public static void main(String[] args) {

        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {

        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            for (int j = i + 1; j < pattern.length(); j++) {
                if (pattern.charAt(i) == pattern.charAt(j) && strs[i].equals(strs[j])) {
                    continue;
                }
                if (pattern.charAt(i) != pattern.charAt(j) && !strs[i].equals(strs[j])) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
