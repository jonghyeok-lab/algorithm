package backjoon.barkingdog._0x04완;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Keylogger_5397 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();

            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) right.addFirst(left.pollLast());
                } else if (c == '>') {
                    if (!right.isEmpty()) left.addLast(right.pollFirst());
                } else if (c == '-') {
                    if (!left.isEmpty()) left.pollLast();
                } else {
                    left.addLast(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            left.forEach(sb::append);
            right.forEach(sb::append);

            System.out.println(sb);
        }

    }
}
