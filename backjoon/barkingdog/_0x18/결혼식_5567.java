package backjoon.barkingdog._0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class 결혼식_5567 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n + 1];
        for (int i = 1; i <= n; i++) {
            persons[i] = new Person(i);
        }

        for (int i = 0; i < m; i++) {
            int[] inputs = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            persons[inputs[0]].friends.add(persons[inputs[1]]);
            persons[inputs[1]].friends.add(persons[inputs[0]]);
        }

        Person sangeun = persons[1];

        Queue<Person> queue = new ArrayDeque<>();
        queue.add(sangeun);

        int[] depth = new int[n + 1];
        depth[1] = 1;

        while (!queue.isEmpty()) {
            Person p = queue.remove();
            if (depth[p.id] > 3) continue;
            for(Person friend : p.friends) {
                if (depth[friend.id] != 0) continue;
                depth[friend.id] = depth[p.id] + 1;
                queue.add(friend);

            }
        }
        int answer = 0;

        for (int d : depth) {
            if (d == 2 || d == 3) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Person {
        int id;
        List<Person> friends = new ArrayList<>();

        public Person(int id) {
            this.id = id;
        }
    }
}
