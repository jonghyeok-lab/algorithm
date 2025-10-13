package backjoon.keundol.threeweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 치킨_배달 {
    private static int[][] map;
    private static int n;
    private static int m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = input[0];
        m = input[1];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] lines = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            map[i] = lines;
        }

        System.out.println(solution(n, m, map));
    }

    private static int solution(int n, int m, int[][] map) {
        List<ChickenHouse> chickenHouses = findChickenHouse(map);

        List<ChickenHouse> selectedChickenHouses = new LinkedList<>();
        getChickenHouse(0, 0, chickenHouses, selectedChickenHouses);

        return answer;
    }

    private static void getChickenHouse(int index, int cnt, List<ChickenHouse> chickenHouses, List<ChickenHouse> selectedChickenHouses) {
        if (m == cnt) {
            answer = Math.min(answer, getDistance(selectedChickenHouses));
            return;
        }
        for (int i = index; i < chickenHouses.size(); i++) {
            ChickenHouse chickenHouse = chickenHouses.get(i);
            selectedChickenHouses.add(chickenHouse);
            getChickenHouse(i + 1, cnt + 1, chickenHouses, selectedChickenHouses);
//            System.out.println(i + " " + chickenHouse + " " + answer);
            selectedChickenHouses.remove(chickenHouse);
        }
    }

    private static int getDistance(List<ChickenHouse> selectedChickenHouses) {
        int totalDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int distance = Integer.MAX_VALUE;
                    for(int k = 0; k < selectedChickenHouses.size(); k++) {
                        ChickenHouse chickenHouse = selectedChickenHouses.get(k);
//                        System.out.println((i + " : " + j));
//                        System.out.println("x: " + chickenHouse.x + " y: " + chickenHouse.y + " distance: " + chickenHouse.distance(i, j));
                        distance = Math.min(chickenHouse.distance(i, j), distance);
                    }
//                    System.out.println(distance);
                    totalDistance += distance;
                }
            }
        }
        return totalDistance;
    }

    private static List<ChickenHouse> findChickenHouse(int[][] map) {
        List<ChickenHouse> chickenHouses = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    ChickenHouse chickenHouse = new ChickenHouse(i, j);
                    chickenHouses.add(chickenHouse);
                }
            }
        }
        return chickenHouses;
    }

    static class ChickenHouse {
        int x;
        int y;

        public ChickenHouse(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(int x, int y) {
            return Math.abs(x - this.x) + Math.abs(y - this.y);
        }

        @Override
        public String toString() {
            return "ChickenHouse{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
