package programmers.level1;

public class KaKao_1차_비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = decode(n, arr1[i], arr2[i]);
        }
        return answer;
    }

    private String decode(int n, int number1, int number2) {
        String str1 = toFormat(toBinary(number1), n);
        String str2 = toFormat(toBinary(number2), n);
        // toFormat(str1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 == '1' || c2 == '1') {
                sb.append("#");
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String toBinary(int number) {
        StringBuilder sb = new StringBuilder();
        while (number > 1) {
            sb.append(number % 2); // 0 0 0 1
            number /= 2; // 4 2 1
        }
        sb.append(number);
        return sb.reverse().toString();
    }

    private String toFormat(String s, int n) {
        // return String.format("%0" + n + "d", Integer.parseInt(s));
        return String.format("%" + n + "s", s).replace(' ', '0');
        // return String.format("%0s", s);
    }
}
