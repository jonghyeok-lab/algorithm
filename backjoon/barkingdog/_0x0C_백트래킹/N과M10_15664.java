package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M10_15664 {

    private static int n;
    private static int m;
    private static int[] arrInputs;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];
        arrInputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int[] ans = new int[m];
        backTracking(ans, 0, 0);
    }

    private static void backTracking(int[] ans, int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i]);
                if (i < m) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for (int i = start; i < arrInputs.length; i++) {
            if (prev == arrInputs[i]) continue;
            ans[depth] = arrInputs[i];
            backTracking(ans, depth + 1, i + 1);

            prev = arrInputs[i];
        }
    }
}
