import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class M2 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] ints = new int[n];
//        for (int i = 0; i < n; i++) {
//            ints[i] = scanner.nextInt();
//        }

            int[] a = {1, 2, 3, 4, 5};
            long result = solve(a);
            System.out.println("Minimum operations required: " + result);

    }
    public static long solve(int a[]) {
        /**
         *  给定一个数组，每一次可以操作数组下标为i和j的值，每次操作a[i]+1和a[j]-1，求使得数组极差最小，所需次数，
         *         数组极差最小是数组中的最大值和最小值的差
         */

        long totalSum = 0;
        for (int elem : a) {
            totalSum += elem;
        }
        // Step 2: Calculate the average value
        int n = a.length;
        double avg = (double) totalSum / n;

        // Step 3: Determine the target values
        int target1 = (int) Math.floor(avg);  // floor of avg
        int target2 = (int) Math.ceil(avg);   // ceil of avg

        // Step 4: Calculate the number of operations needed
        long operations = 0;
        for (int elem : a) {
            if (elem < target1) {
                operations += target1 - elem;
            } else if (elem > target2) {
                operations += elem - target2;
            }
        }

        return operations / 2;
    }

}
