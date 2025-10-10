package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 부분수열의합_1182 {
    private static int N;
    private static int S;
    private static int answer;
    private static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = inputs[0];
        S = inputs[1];

        array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        for (int i = 0; i < N; i++) {
//            int num = array[i];
            dfs(0, 0, 0);
//        }
        System.out.println(answer);
    }

    private static void dfs(int cnt, int sum, int size) {
        if (sum == S && size != 0) {
            answer++;
//            return;
        }

        for (int i = cnt; i < N; i++) {

            int num = array[i];
//            System.out.println(cnt + " " + i + " " + num + " " + (sum + num));
            dfs(i + 1, sum + num, size + 1);
        }
    }
}
