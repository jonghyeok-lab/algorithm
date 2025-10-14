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

        // 1 7 9 9
        dfs(0, new int[m]);
    }

    private static void dfs(int cnt, int[] answer) {
        if (cnt == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
//            System.out.println(Arrays.toString(answer));
            return;
        }
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (prev == arrInputs[i]) continue;
            answer[cnt] = arrInputs[i];
            visited[i] = true;
            dfs(cnt + 1, answer);
            prev = arrInputs[i];
            visited[i] = false;
        }
    }


}
