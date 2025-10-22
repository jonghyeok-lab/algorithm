package programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class PG_리코쳇로봇 {

    private final int[] dy = {-1, 0, 1, 0};
    private final int[] dx = {0, -1, 0, 1};
    private static boolean[][] visited;

    public int solution(String[] board) {
        int answer = 0;
        char[][] map = new char[board.length][board[0].length()];
        Queue<Point> queue = new ArrayDeque<>();
        visited = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                map[i][j] = row[j];
                if (row[j] == 'R') queue.add(new Point(i, j, 0));
            }
        }

        while (!queue.isEmpty()) {
            Point here = queue.poll();
            visited[here.y][here.x] = true;

            for (int i = 0; i < 4; i++) {
                Point next = dfs(dy[i], dx[i], map, here);
                if (visited[next.y][next.x]) continue;
                if (map[next.y][next.x] == 'G') return next.count;
                queue.add(next);
            }
        }
        return -1;
    }

    private Point dfs(int y, int x, char[][] map, Point point) {
        int ny = point.y + y;
        int nx = point.x + x;

        if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length)
            return new Point(point.y, point.x, point.count + 1);
        // if (visited[ny][nx]) return null;
        if (map[ny][nx] == 'D') {

            return (new Point(point.y, point.x, point.count + 1));
        }
        return dfs(y, x, map, new Point(ny, nx, point.count));
    }

    static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
