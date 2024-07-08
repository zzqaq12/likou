import java.util.HashSet;

public class L202 {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     */
    public static void main(String[] args) {

        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> integers = new HashSet<>();
        while (n != 1) {
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (n == 1) {
                return true;
            } else if (integers.contains(n)) {
                return false;
            } else {
                integers.add(n);
            }
        }
        return true;
    }
}
