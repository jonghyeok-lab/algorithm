package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M_12_15666 {
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
        backTracking(0, ans, 0);
    }

    private static void backTracking(int cnt, int[] ans, int start) {
        if (cnt == m) {
            StringBuilder sb = new StringBuilder();
            for(int i : ans) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int prev = -1;
        for (int i = start; i < arrInputs.length; i++) {
            if (arrInputs[i] == prev) continue;
            ans[cnt] = arrInputs[i];
            backTracking(cnt + 1, ans, i);
            prev = arrInputs[i];
        }
    }
}
