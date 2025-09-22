package backjoon.barkingdog._0x18_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 구슬_2617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int M = input[1];

        Ball[] heavyBallArr = new Ball[N + 1];
        Ball[] lightBallArr = new Ball[N + 1];
        for(int i = 1; i <= N; i++) {
            heavyBallArr[i] = new Ball(i);
            lightBallArr[i] = new Ball(i);
        }

        for(int i = 0; i < M; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int heavy = array[0];
            int light = array[1];
            heavyBallArr[heavy].balls.add(heavyBallArr[light]); // 2 -> 1
            lightBallArr[light].balls.add(lightBallArr[heavy]); // 1 -> 2
        }
        Set<Integer> answer = findAnswer(N, heavyBallArr);
        boolean x = answer.addAll(findAnswer(N, lightBallArr));

        System.out.println(answer.size());
    }

    private static Set<Integer> findAnswer(int N, Ball[] balls) {
        int max = N / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int count = dfs(balls[i], visited);
            if (count > max) set.add(i);
        }
        return set;
    }

    private static int dfs(Ball ball, boolean[] visited) {
        int result = 0;
        visited[ball.idx] = true;
        if (ball.balls.isEmpty()) {
            return result;
        }

        for (Ball b : ball.balls) {
            if (visited[b.idx]) continue;
            result += 1 + dfs(b, visited);
        }
        return result;
    }

    static class Ball {
        int idx;
        List<Ball> balls = new ArrayList<>();

        public Ball(int idx) {
            this.idx = idx;
        }
    }
}
