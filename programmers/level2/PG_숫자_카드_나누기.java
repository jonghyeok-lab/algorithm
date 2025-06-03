package programmers.level2;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PG_숫자_카드_나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Set<Integer> setA = Arrays.stream(arrayA).boxed().collect(Collectors.toSet());
        Set<Integer> setB = Arrays.stream(arrayB).boxed().collect(Collectors.toSet());

        int maxArrayA = arrayA[0];
        int maxArrayB = arrayB[0];

        int max = Math.max(maxArrayA, maxArrayB);

        for (int i = 1; i <= 100000000; i++) {
            if (i > max) break;
            if (shouldOdd(setA, i) && shouldNotOdd(setB, i)) answer = i;
            if (shouldOdd(setB, i) && shouldNotOdd(setA, i)) answer = i;
        }

        return answer;
    }

    public boolean shouldOdd(Set<Integer> target, int number) {
        // boolean result = false;

        for (int a : target) {
            if (a % number != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean shouldNotOdd(Set<Integer> target, int number) {
        for (int a : target) {
            if (a % number == 0) {
                return false;
            }
        }
        return true;

    }
}

