public class L9 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数
     * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public static void main(String[] args) {

        System.out.println(new L9().isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int res = 0;
        while (temp != 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res == x;
    }
}
