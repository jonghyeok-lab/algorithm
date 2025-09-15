package backjoon.barkingdog._0x18_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장뽑기_2660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n + 1];
        for(int i = 1; i <= n; i++) {
            persons[i] = new Person(i);
        }

        while (true) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (inputs[0] == -1) break;

            persons[inputs[0]].friends.add(persons[inputs[1]]);
            persons[inputs[1]].friends.add(persons[inputs[0]]);
        }

        List<Answer> answers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            Person person = persons[i];

            Queue<Person> queue = new LinkedList<>();
            queue.add(person);
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;
            int[] depth = new int[n + 1];

            while (!queue.isEmpty()) {
                Person poll = queue.poll();

                for(Person pollFriend : poll.friends) {
                    if (visited[pollFriend.id]) continue;
                    visited[pollFriend.id] = true;
                    depth[pollFriend.id] = depth[poll.id] + 1;
                    queue.add(pollFriend);
                }
            }
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                if (!visited[j]) {
                    max = -1;
                    break;
                }
                max = Math.max(max, depth[j]);
            }

            if (max == -1) continue;
            answers.add(new Answer(i, max));
        }

        Answer min = answers.stream()
                .min((a1, a2) -> a1.value - a2.value)
                .get();

        int[] array = answers.stream()
                .filter(each -> each.value == min.value)
                .mapToInt(each -> each.idx)
                .toArray();
        System.out.println(min.value + " " + array.length);
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    static class Answer {
        int idx;
        int value;

        public Answer(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static class Person {
        int id;
        List<Person> friends;

        public Person(int id) {
            this.id = id;
            friends = new ArrayList<>();
        }
    }
}
