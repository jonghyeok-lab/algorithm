package backjoon.barkingdog._0x18_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class 숨바꼭질_6118 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = parseInput(br.readLine());
        int n = inputs[0];
        int m = inputs[1];

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= m; i++) {
            int[] ints = parseInput(br.readLine());
            nodes[ints[0]].nextNodes.add(nodes[ints[1]]);
            nodes[ints[1]].nextNodes.add(nodes[ints[0]]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Node start = nodes[1];
        visited[start.idx] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.nextNodes) {
                if (visited[next.idx]) continue;
                visited[next.idx] = true;

                queue.add(next);
                distance[next.idx] = distance[cur.idx] + 1;
            }
        }
        int[] copy = distance.clone();
        Arrays.sort(distance);

        int secondAnswer = distance[distance.length - 1];
        boolean flag = false;
        int firstAnswer = 0;
        int thirdAnswer = 0;
        for (int i = 1; i <= n; i++) {
            if (!flag && copy[i] == secondAnswer) {
                flag = true;
                firstAnswer = i;
            }
            if (copy[i] == secondAnswer) {
                thirdAnswer++;
            }
        }
        System.out.println(firstAnswer + " " + secondAnswer + " " + thirdAnswer);
    }

    private static int[] parseInput(String input) {
        return Stream.of(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static class Node {
        int idx;
        List<Node> nextNodes = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }
    }
}
