package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class KaKao_성격_유형_검사하기 {

    private final Map<String, Integer> map; // 성격

    public KaKao_성격_유형_검사하기() {
        map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 3 2 1 0 1 2 3 점수
        for (int i = 0; i < survey.length; i++) {
            char[] scoreBoards = survey[i].toCharArray();
            int select = choices[i]; // 1 2 3 4 5 6 7
            if (select == 4) continue;
            if (1 <= select && select < 4) {
                int origin = map.get(scoreBoards[0] + "");
                map.put((scoreBoards[0] + ""), origin + 4 - select);
            }
            if (4 < select && select <= 7) {
                int origin = map.get(scoreBoards[1] + "");
                map.put((scoreBoards[1] + ""), origin + select - 4);
            }
        }

        return findAnswer();
        // return answer;
    }

    private String findAnswer() {
        StringBuilder sb = new StringBuilder();

        int value1 = map.get("R");
        int value2 = map.get("T");

        if (value1 >= value2) {
            sb.append("R");
        } else {
            sb.append("T");
        }

        int value3 = map.get("C");
        int value4 = map.get("F");

        if (value3 >= value4) {
            sb.append("C");
        } else {
            sb.append("F");
        }

        int value5 = map.get("J");
        int value6 = map.get("M");

        if (value5 >= value6) {
            sb.append("J");
        } else {
            sb.append("M");
        }

        int value7 = map.get("A");
        int value8 = map.get("N");

        if (value7 >= value8) {
            sb.append("A");
        } else {
            sb.append("N");
        }

        return sb.toString();
    }

}
