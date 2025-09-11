package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KaKao_이모티콘_할인행사 {

    private static int[] discountRate = {10, 20, 30, 40};
    private static int[] applied;
    private static List<Calculated> list = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        // 1. 서비스 가입자 최대한 늘리기
        // 2. 판매액 최대한 늘리기
        // 3. 1번이 우선 -> 2번
        // n : 사용자, m : 할인해서 판매할 이모티콘 개수
        // 이모티콘 할인율 : 10% 20, 30, 40 중 하나
        // 자신의 기준 -> 이모티콘 모두 구매 -> 합이 일정 가격 이상이라면, 서비스 가입


        // 6300, 5600, 4900, 4200  8100, 7200, 6300, 5400
        // 10 10 10 10 -> 10 10 10 20 -> 10 10 10 30 -> 10 10 10 40 -> 20 10 10 10
        applied = new int[emoticons.length];

        getDiscountRate(0, users, emoticons);
        List<Calculated> results = list.stream()
                .sorted(Calculated::compareTo)
                .collect(Collectors.toList());

        return new int[]{results.get(0).register, results.get(0).total};
    }

    private void getDiscountRate(int here, int[][] users, int[] emoticons) {
        if (here == applied.length) {
            Calculated result = doDiscount(users, emoticons);
            list.add(result);
            return;

        }

        for (int rate : discountRate) {
            applied[here] = rate;
            getDiscountRate(here + 1, users, emoticons);
        }
    }

    private Calculated doDiscount(int[][] users, int[] emoticons) {
        int register = 0;
        int total = 0;
        for (int i = 0; i < users.length; i++) {
            int sum = 0;
            for (int j = 0; j < applied.length; j++) {
                if (users[i][0] <= applied[j]) {
                    sum += emoticons[j] / 100 * (100 - applied[j]);
                }
            }

            if (users[i][1] <= sum) {
                register++;
            } else {
                total += sum;
            }
            // System.out.println("users[i][0] : " + users[i][0] + " sum : " + sum + " register : " + register + " total : " + total);
        }
        // System.out.println(register + " : " + total);
        return new Calculated(register, total);
    }

    static class Calculated implements Comparable<Calculated> {
        int register;
        int total;

        public Calculated(int register, int total) {
            this.register = register;
            this.total = total;
        }

        public int compareTo(Calculated other) {
            if (this.register == other.register) {
                return other.total - this.total;
            }
            return other.register - this.register;
        }
    }
}
