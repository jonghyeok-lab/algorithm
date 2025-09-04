package backjoon.barkingdog._0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class NumbersSum2_2003 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] array = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int left = 0;
        int answer = 0;
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            while (sum >= M) {
                if (sum == M) { answer++;}
                sum -= array[left++];
            }
        }
        System.out.println(answer);
    }
}
