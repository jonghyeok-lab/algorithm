package backjoon.barkingdog._0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class PartSum_1806 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);

        int[] array = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (S == 0) {
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 100001;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            right = i;
            if (array[i] == S) {
                System.out.println(1);
                return;
            }
            while (sum >= S) {
                answer = Math.min(answer, right - left + 1);
                sum -= array[left++];
            }
        }
        System.out.println(answer == 100001 ? 0 : answer);
    }
}
