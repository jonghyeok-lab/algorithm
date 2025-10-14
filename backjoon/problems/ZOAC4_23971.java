package backjoon.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZOAC4_23971 {
    private static int H;
    private static int W;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        H = inputs[0];
        W = inputs[1];
        N = inputs[2];
        M = inputs[3];
        int cnt = 0;
        for (int i = 0; i < H; i += (N + 1)) {
            for(int j = 0; j < W; j += (M + 1)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
