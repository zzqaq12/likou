import java.util.Scanner;

public class Y2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean b = solve(m, n);
        System.out.println(b);
    }
    public static boolean solve(int m, int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum *= n / i;

            }
            if (n % i != 0) {
                sum *= n % i;
            }
            if (sum > m)
                return true;
            sum = 1;
        }
        return false;
    }

}
