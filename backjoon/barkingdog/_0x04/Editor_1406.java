package backjoon.barkingdog._0x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Editor_1406 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = new ArrayDeque<>();
        for(char c : input.toCharArray()) {
            left.add(c + "");
        }
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] inputs = br.readLine().split(" ");
            String firstInput = inputs[0];
            if ("L".equals(firstInput)) {
                if (!left.isEmpty()) right.addFirst(left.pollLast());
            }
            if ("D".equals(firstInput)) {
                if (!right.isEmpty()) left.addLast(right.pollFirst());
            }
            if ("B".equals(firstInput)) {
                if (!left.isEmpty()) left.pollLast();
            }
            if ("P".equals(firstInput)) {
                left.addLast(inputs[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        left.forEach(sb::append);
        right.forEach(sb::append);
        System.out.println(sb);
    }
}
