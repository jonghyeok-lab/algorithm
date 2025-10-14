package backjoon.barkingdog._0x0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663 {
    private static int N;
    private static int answer;
    private static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        for (int i = 0; i < N; i++) {
            board[0] = i;
            dfs(1);
        }

        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            answer++;
            return;
        }

        // cnt 가 1 -> (1, 0)
        for (int i = 0; i < N; i++) {
            if (canPlace(cnt, i)) {
                board[cnt] = i;
                dfs(cnt + 1);
            }
        }
    }

    private static boolean canPlace(int row, int col) {
        for (int i = 0; i < row; i++) {
            int placedCol = board[i];
            if (col == placedCol) return false;
            if (Math.abs(row - i) == Math.abs(col - placedCol)) return false;
        }
        return true;
    }
}
