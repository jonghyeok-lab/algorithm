package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로또_6603 {

    private static int[] arr;
    private static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if ("0".equals(input)) break;
            int[] inputs = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            k = inputs[0];
            arr = new int[k];
            for (int i = 1; i < inputs.length; i++) {
                arr[i - 1] = inputs[i];
            }

            int[] ans = new int[6];
            backTracking(ans, 0, 0);
            System.out.println();
        }
    }

    private static void backTracking(int[] ans, int cnt, int start) {
        if (6 == cnt){
            for (int i = 0; i < 6; i++) {
                System.out.print(ans[i]);
                if (i < 5) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        // cnt = 0 / 1 / 2 / 3 / 4 / 5
        for (int i = start; i < arr.length; i++) {
            ans[cnt] = arr[i];
            backTracking(ans, cnt + 1, i + 1);
            ans[cnt] = 0;
        }
    }
}
