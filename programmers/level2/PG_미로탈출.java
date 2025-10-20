package programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class PG_미로탈출 {

    private final int[] dy = {-1, 0, 1, 0};
    private final int[] dx = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int y = 0;
        int x = 0;

        char[][] miro = new char[maps.length][maps[0].length()];
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] line = maps[i].toCharArray();
            for (int j = 0; j < line.length; j++) {
                miro[i][j] = line[j];
                if (line[j] == 'S') {
                    q.add(new Point(i, j));

                }
            }
        }

        while (!q.isEmpty()) {
            Point here = q.poll();
            visited[here.y][here.x] = true;
            // System.out.println(here.y + " : " + here.x);
            if (miro[here.y][here.x] == 'L') {
                q = new ArrayDeque<>();
                q.add(new Point(here.y, here.x));
                visited = new boolean[maps.length][maps[0].length()];
                answer += here.distance;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = here.y + dy[i];
                int nx = here.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length()) continue;
                if (visited[ny][nx] || miro[ny][nx] == 'X') continue;

                visited[ny][nx] = true;
                q.add(new Point(ny, nx, here.distance + 1));
            }
        }

        if (answer == 0) return -1;
        int origin = answer;
        while (!q.isEmpty()) {
            Point here = q.poll();
            visited[here.y][here.x] = true;
            // System.out.println(here.y + " : " + here.x);
            if (miro[here.y][here.x] == 'E') {
                answer += here.distance;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = here.y + dy[i];
                int nx = here.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length()) continue;
                if (visited[ny][nx] || miro[ny][nx] == 'X') continue;

                visited[ny][nx] = true;
                q.add(new Point(ny, nx, here.distance + 1));
            }
        }

        if (origin == answer) return -1;


        return answer;
    }

    static class Point {
        int y;
        int x;
        int distance;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
            this.distance = 0;
        }

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        public Point addDistance() {
            return new Point(y, x, distance++);
        }
    }
}
