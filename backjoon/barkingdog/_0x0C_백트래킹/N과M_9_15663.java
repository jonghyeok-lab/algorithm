package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M_9_15663 {

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
        visited = new boolean[n];

        int[] arr = new int[m];
        start(0, arr);
    }

    // 1 7 9 9
    private static void start(int idx, int[] arr) {
        if (idx == m) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;
        for(int i = 0; i < arrInputs.length; i++) {
            if (visited[i]) continue;
            if (arrInputs[i] == prev) continue;
            visited[i] = true;
            arr[idx] = arrInputs[i];
            start(idx + 1, arr);
            visited[i] = false;

            prev = arrInputs[i];
        }
    }
}
