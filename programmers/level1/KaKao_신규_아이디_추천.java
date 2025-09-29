package programmers.level1;

public class KaKao_신규_아이디_추천 {

    public String solution(String new_id) {
        String answer = "";

        String oneStep = toLowerCase(new_id);
        String twoStep = toTwoStep(oneStep);
        String threeStep = toThreeStep(twoStep);
        String fourStep = toFourStep(threeStep);
        String five = toFiveStep(fourStep);
        String six = toSixStep(five);
        String seven = toSeven(six);

        System.out.println(fourStep);
        return seven;
    }

    private String toSeven(String input) {
        while (input.length() <= 2) {
            input += input.charAt(input.length() - 1);
        }
        return input;
    }

    private String toSixStep(String input) {
        if (input.length() >= 16) {
            input = input.substring(0, 15);
        }

        return toFourStep(input);
    }

    private String toFiveStep(String input) {
        if ("".equals(input)) return "a";
        return input;
    }

    private String toFourStep(String input) {
        char first = input.charAt(0);

        if (first == '.') {
            input = input.substring(1);
        }

        if (input.isEmpty()) {
            return "";
        }
        char last = input.charAt(input.length() - 1);
        if (last == '.') {
            input = input.substring(0, input.length() - 1);
        }

        return input;
    }

    private String toThreeStep(String input) {
        while (input.indexOf("..") != -1) {
            input = input.replace("..", ".");
        }
        return input;
    }

    private String toTwoStep(String input) {
        // String regax = "[^a-z_.0-9-]";
        // return input.replaceAll(regax, "");
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if ('0' <= c && c <= '9') {
                sb.append(c);
            }
            if ('-' == c || '.' == c || '_' == c) {
                sb.append(c);
            }
            if ('a' <= c && c <= 'z') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String toLowerCase(String input) {
        return input.toLowerCase();
    }
}

