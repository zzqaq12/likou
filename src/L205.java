public class L205 {
    //同构字符串

    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     */
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        isIsomorphic(s,t);
    }

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }
            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
        }
        return true;

    }
}
