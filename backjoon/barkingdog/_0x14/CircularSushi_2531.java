package backjoon.barkingdog._0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class CircularSushi_2531 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);

        int[] sushiBelt = new int[N + k - 1];
        List<Integer> sushis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int sushiNumber = Integer.parseInt(br.readLine());
//            sushis.add(sushiNumber);
            sushiBelt[i] = sushiNumber;
        }

        for (int i = 0; i < k - 1; i++) {
            sushiBelt[N + i] = sushiBelt[i];
        }
        System.out.println(Arrays.toString(sushiBelt));


        Deque<Integer> sushiSet = new ArrayDeque<>();
        int answer = 0;
        int left = 0;
        for (int i = 0; i < sushiBelt.length; i++) {
            sushiSet.add(sushiBelt[i]); //  7 9 30
            if (i - left + 1 == k) {
                sushiSet.add(c);

//                System.out.println(sushiSet);
                Set<Integer> sushiSize = new HashSet<>(sushiSet);
                answer = Math.max(sushiSize.size(), answer);

                sushiSet.poll();
                sushiSet.pollLast();
                left++;
            }
        }
        System.out.println(answer);
    }
}
