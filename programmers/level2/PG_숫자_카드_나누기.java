package programmers.level2;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PG_숫자_카드_나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int minA = getMin(arrayA);
        int minB = getMin(arrayB);

        int gcdA = getGcd(arrayA, minA);
        int gcdB = getGcd(arrayB, minB);

        answer = Math.max(getAnswer(gcdA, arrayB), answer);
        answer = Math.max(getAnswer(gcdB, arrayA), answer);

        return answer;
    }

    private int getAnswer(int gcd, int[] target) {
        for (int a : target) {
            if (a % gcd == 0) {
                return 0;
            }
        }
        return gcd;
    }

    private int getMin(int[] target) {
        return Arrays.stream(target)
                .reduce((a, b) -> Math.min(a, b))
                .getAsInt();
    }

    private int getGcd(int[] target, int minValue) {
        int gcd = 1;

        for (int i = 2; i <= minValue; i++) {
            if (isGcd(target, i)) {
                gcd = i;
            }
        }
        return gcd;
    }

    private boolean isGcd(int[] target, int value) {
        for (int a : target) {
            if (a % value != 0) {
                return false;
            }
        }
        return true;
    }
}

