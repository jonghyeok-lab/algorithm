package programmers.level2;

import java.util.Stack;

public class KaKao_괄호변환 {

    public String solution(String p) {
        if ("".equals(p)) return "";
        if (isCorrect(p)) return p;

        String[] separated = separate(p);
        // System.out.println(Arrays.toString(separated));

        return doo(separated);
    }

    private String doo(String[] separated) {
        String u = separated[0];
        String v = separated[1];

        if (isCorrect(u)) {
            return u + solution(v);
        }

        String start = "(" + solution(v) + ")";
        String discarded = u.substring(1, u.length() - 1);

        StringBuilder sb = new StringBuilder();
        for (char c : discarded.toCharArray()) {
            if (c == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return start + sb.toString();
    }

    private String[] separate(String p) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                index = i;
                break;

            }
        }
        return new String[]{p.substring(0, index + 1), p.substring(index + 1)};
    }

    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
