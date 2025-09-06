package backjoon.barkingdog._0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수_고르기_2230 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = inputs[0];
        int M = inputs[1];

        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (right < N && left < N) {
            int diff = array[right] - array[left];

            if (diff < M) {
                right++;
            }
            if (diff >= M) {
                answer = Math.min(answer, diff);
                left++;
            }
        }


        System.out.println(answer);

        // 1 3 7 8 13

    }
}
