import java.util.ArrayList;
import java.util.List;

public class L17 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] numString = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        List<String> res = new ArrayList<>();
//        res.add("");
//        // 循环次数
//        for (int i = 0; i < digits.length(); i++) {
//            int index = Character.getNumericValue(digits.charAt(i)) - 2;
//            while (res.get(0).length() == i) {
//                // 移除第一个元素
//                String t = res.remove(0);
//                // 遍历字符串
//                for (char s : numString[index].toCharArray()) {
//                    // 添加元素
//                    res.add(t + s);
//                }
//            }
//        }
//        return res;
        //回溯法
        List<String> res = new ArrayList<>();
        backtrack(digits, numString, 0, new StringBuffer(), res);
        return res;


    }

    private static void backtrack(String digits, String[] numString, int i, StringBuffer stringBuffer, List<String> res) {
        // 终止条件
        if (stringBuffer.length() == digits.length()) {
            res.add(stringBuffer.toString());
            return;
        }
        int index = Character.getNumericValue(digits.charAt(i)) - 2;
        for (char s : numString[index].toCharArray()) {
            stringBuffer.append(s);
            backtrack(digits, numString, i + 1, stringBuffer, res);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
