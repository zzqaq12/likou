import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Y3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] tasks = new int[N];
        for (int i = 0; i < N; i++) {
            tasks[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();
        solve(N, tasks, M);
    }
    public static int[] solve(int n, int []tasks, int m){
        int[] dp = new int[n];
        int[] path = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        dp[0] = tasks[0];
        for (int i = 1; i < n; i++) {
            if (tasks[i] == -1)
                continue;
            for (int j = Math.max(0, i - m); j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && dp[j] + tasks[i] < dp[i]) {
                    dp[i] = dp[j] + tasks[i];
                    path[i] = j ; // Remember the previous task
                } else if (dp[j] + tasks[i] == dp[i] && j < path[i]) {
                    // If we have equal times, choose the smaller index
                    path[i] = j;
                }
            }
        }

        int[] result = reconstructPath(path, n - 1);

        return result;

    }

    private static int[] reconstructPath(int[] path, int current) {
        ArrayList<Integer> list = new ArrayList<>();
        while (current != -1) {
            list.add(current + 1);
            current = path[current];
        }

        // Convert the ArrayList to an array and reverse it
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }

        return result;
    }
}
