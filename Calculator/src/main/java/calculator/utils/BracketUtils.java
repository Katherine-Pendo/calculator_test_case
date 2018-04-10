package main.java.calculator.utils;

import static main.java.calculator.Main.*;

public abstract class BracketUtils {

    public static int getBracketsCount(String expression) {

        int count = 0;

        for (char character : expression.toCharArray()) {
            if (character == LEFT_BRACKET)
                count++;
        }
        return count;
    }

    public static String leaveOnlyBrackets(String expression) {
        StringBuilder sb = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (c == LEFT_BRACKET || c == RIGHT_BRACKET)
                sb.append(c);
        }
        return sb.toString();
    }

}
