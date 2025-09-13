package programmers.level2;

import java.util.Arrays;

public class KaKao_양궁대회 {

    private static int MIN_VALUE = Integer.MIN_VALUE;
    private int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        int[] lion = new int[info.length];
        dfs(0, n, info, lion);
        if (MIN_VALUE == Integer.MIN_VALUE) return new int[]{-1};
        return answer;
    }

    private void dfs(int idx, int remain, int[] info, int[] lion) {
        if (idx == 11) {
            if (remain > 0) lion[info.length - 1] += remain;

            int apeachTotal = 0;
            int lionTotal = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] >= lion[i]) {
                    if (info[i] != 0) {
                        apeachTotal += 10 - i;
                    }
                } else {
                    lionTotal += 10 - i;
                }
            }
            // System.out.println(lionTotal + " : " + apeachTotal);
            int diff = lionTotal - apeachTotal;
            if (diff > 0) {


                if (MIN_VALUE < diff) {
                    MIN_VALUE = diff;
                    answer = Arrays.copyOf(lion, lion.length);
                    // System.out.println("answer : " + Arrays.toString(answer));
                } else if (MIN_VALUE == diff) {
                    for (int i = lion.length - 1; i >= 0; i--) {
                        if (answer[i] < lion[i]) {
                            answer = Arrays.copyOf(lion, lion.length);
                            break;
                        }
                        if (answer[i] > lion[i]) break;
                    }
                }
            }

            if (remain > 0) lion[info.length - 1] -= remain;
            return;
        }

        if (remain - (info[idx] + 1) >= 0) {
            lion[idx] = info[idx] + 1;
            dfs(idx + 1, remain - info[idx] - 1, info, lion);
            lion[idx] = 0;
        }
        dfs(idx + 1, remain, info, lion);
    }
}
