public class CN {
    public static void main(String[] args) {
        char[][] chars = new char[4][3];
        boolean flag = chars[1][1] == '\u0000';
        System.out.println(flag);
    }
}
