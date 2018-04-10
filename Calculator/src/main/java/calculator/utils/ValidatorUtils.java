package main.java.calculator.utils;

import java.util.ArrayList;

import static main.java.calculator.utils.BracketUtils.*;
import static main.java.calculator.Main.*;
import static main.java.calculator.utils.TypeUtils.*;

public abstract class ValidatorUtils {

    /**
     * Метод проверяет корректность выражения.
     * Если выражение правильное, возвращаем его, иначе исключение
     */
    public static String isValidExpression(String expression) throws Exception {

        if (!isValidLength(expression))
            throw new Exception("Вы ввели слишком большое количество символов");
        if (!isValidWhitespaces(expression))
            throw new Exception("Пробелы недопустимы в выражении");
        if (!isValidSymbols(expression))
            throw new Exception("Вы ввели неизвестный(ые) символ(ы)");
        if (!isValidEnd(expression))
            throw new Exception("Выражение незакончено");

        if (expression.contains(String.valueOf(LEFT_BRACKET)) || expression.contains(String.valueOf(RIGHT_BRACKET))) {
            if (!isValidBracketsCount(expression))
                throw new Exception("Несовпадает количесвто скобок");
            if (!isValidBracketsSequence(leaveOnlyBrackets(expression)))
                throw new Exception("Несовпадает последовательность скобок");
        }

        if (!isValidTypesSequence(getArrayOfTypes(expression)))
            throw new Exception("Ошибка ввода");


        return expression;
    }

    /**
     * Метод проверяет последовательность типов
     * Если выражение правильное, возвращаем true, иначе false
     */
    private static boolean isValidTypesSequence(ArrayList<String> arrayOfTypes) {

        boolean pointEntered = false;

        String currentType = arrayOfTypes.get(0);
        arrayOfTypes.remove(0);

        if (!arrayOfTypes.isEmpty()) {
            for (String type : arrayOfTypes) {
                switch (currentType) {
                    case TYPE_DIGIT: {
                        if (!type.equals(TYPE_BRACKET_RIGHT) && !type.equals(TYPE_DIGIT) &&
                                !type.equals(TYPE_MATH_SIGN) && !type.equals(TYPE_POINT) && !type.equals(TYPE_MATH_SIGN_MINUS))
                            return false;

                        currentType = type;
                    }
                    break;
                    case TYPE_POW_START: {
                        if (!type.equals(TYPE_BRACKET_LEFT) && !type.equals(TYPE_DIGIT) && !type.equals(TYPE_MATH_SIGN_MINUS))
                            return false;

                        currentType = type;
                    }
                    break;
                    case TYPE_SQRT_START: {
                        if (!type.equals(TYPE_BRACKET_LEFT) && !type.equals(TYPE_DIGIT))
                            return false;


                        currentType = type;
                    }
                    break;
                    case TYPE_BRACKET_LEFT: {
                        if (!type.equals(TYPE_BRACKET_LEFT) && !type.equals(TYPE_DIGIT) && !type.equals(TYPE_MATH_SIGN_MINUS))
                            return false;

                        currentType = type;
                    }
                    break;
                    case TYPE_BRACKET_RIGHT: {
                        if (!type.equals(TYPE_BRACKET_RIGHT) && !type.equals(TYPE_MATH_SIGN) && !type.equals(TYPE_MATH_SIGN_MINUS))
                            return false;

                        pointEntered = false;
                        currentType = type;
                    }
                    break;
                    case TYPE_POINT: {
                        if (!type.equals(TYPE_DIGIT) || pointEntered)
                            return false;

                        pointEntered = true;
                        currentType = type;
                    }
                    break;
                    case TYPE_MATH_SIGN: {
                        if (!type.equals(TYPE_BRACKET_LEFT) && !type.equals(TYPE_DIGIT) &&
                                !type.equals(TYPE_SQRT_START) && !type.equals(TYPE_POW_START))
                            return false;

                        pointEntered = false;
                        currentType = type;
                    }
                    break;
                    case TYPE_MATH_SIGN_MINUS: {
                        if (!type.equals(TYPE_BRACKET_LEFT) && !type.equals(TYPE_DIGIT) &&
                                !type.equals(TYPE_SQRT_START) && !type.equals(TYPE_POW_START))
                            return false;

                        pointEntered = false;
                        currentType = type;
                    }
                    break;
                }
            }
        } else
            return false;

        return true;
    }

    /**
     * Метод проверяет все символы выражение.
     * Если все символы корректны, возвращаем true, иначе false
     */
    private static boolean isValidSymbols(String expression) {
        for (int i = 0; i < expression.length(); i++) {

            if (i > 0) {
                if (expression.charAt(i - 1) == 's') {
                    i += 4;
                } else if (expression.charAt(i - 1) == 'p') {
                    i += 3;
                }
            }

            char character = expression.charAt(i);

            if (!Character.isDigit(character) &&
                    !(Character.isLetter(character) && isValidLetterStart(character) && isValidLetters(i, expression)) &&
                    !(isValidSign(character)))
                return false;
        }
        return true;

    }

    /**
     * Метод проверяет окончание выражения
     * Если окончание корректно, возвращаем true, иначе false
     */
    private static boolean isValidEnd(String expression) {
        String lastSymbol = String.valueOf(expression.charAt(expression.length() - 1));
        return !lastSymbol.equals(SYMBOL_DIV) && !lastSymbol.equals(SYMBOL_MINUS) &&
                !lastSymbol.equals(SYMBOL_PLUS) && !lastSymbol.equals(SYMBOL_MULTIPLE);

    }

    /**
     * Метод проверяет последовательность скобок
     * Если все верно, возвращаем true, иначе false
     */
    private static boolean isValidBracketsSequence(String expression) {
        String spitedExpression;

        try {
            int lastLeftBracket = expression.lastIndexOf(LEFT_BRACKET);
            int closestRightBracket = expression.charAt(lastLeftBracket + 1) == RIGHT_BRACKET ? lastLeftBracket + 1 : -1;

            if (lastLeftBracket == -1 || closestRightBracket == -1)
                return false;
            spitedExpression = expression.substring(0, lastLeftBracket) + expression.substring(closestRightBracket + 1);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }

        return spitedExpression.length() == 0 || isValidBracketsSequence(spitedExpression);
    }

    /**
     * Метод проверяет длину выражении.
     * Если длина меньше 40  и больше 0, возвращаем true, иначе false
     */
    private static boolean isValidLength(String expression) {
        return expression.length() > 0 && expression.length() < 40;
    }

    /**
     * Метод проверяет количество скобок в выражении.
     * Если количество левых и правых скобок отличается возвращаем false, иначе true
     */
    private static boolean isValidBracketsCount(String expression) {

        int leftBracketCount = 0;
        int rightBracketCount = 0;

        for (char character : expression.toCharArray()) {
            if (character == LEFT_BRACKET)
                leftBracketCount++;
            else if (character == RIGHT_BRACKET)
                rightBracketCount++;
        }

        return leftBracketCount == rightBracketCount;
    }


    /**
     * Метод проверяет наличие пробелов в выражении.
     * Если пробелов нет, возвращаем true, иначе false
     */
    private static boolean isValidWhitespaces(String expression) {
        return expression.length() == expression.trim().length();
    }

    /**
     * Метод проверяет соответствие знака выражения с арифметическими знаками, точкой и скобками.
     * Если знак является таковым, возвращаем true, иначе false
     */
    public static boolean isValidSign(char sign) {
        return sign == '/' || sign == '*' || sign == '+' || sign == '-' || sign == '.' || sign == LEFT_BRACKET || sign == RIGHT_BRACKET;
    }

    /**
     * Метод проверяет первую букву в функции s || p.
     * Если буква является s либо p, возвращаем true, иначе false
     */
    public static boolean isValidLetterStart(char letter) {
        return letter == 's' || letter == 'p';
    }

    /**
     * Метод проверяет все буквы в функции.
     * Если функция является sqrt() либо pow(), возвращаем индекс с учетом смещения, иначе -1
     */
    public static boolean isValidLetters(int start, String expression) {

        int size = (expression.charAt(start) == 's' ? 5 : 4) + start;

        if (size >= expression.length())
            return false;

        StringBuilder func = new StringBuilder();
        for (int i = start; i < size; i++) {
            func.append(expression.charAt(i));
        }

        return func.toString().equals("sqrt(") || func.toString().equals("pow(");
    }

    /**
     * Метод проверяет количество скобочек перед нашией фнкцией.
     * Если количество левых скобочек > количества правых, возвращаем true, иначе false
     */
    @Deprecated
    private static boolean isValidBracketsCountBefore(int size, String expression) {

        int leftBracketCount = 0;
        int rightBracketCount = 0;

        for (int i = 0; i < size - 1; i++) {
            if (expression.charAt(i) == LEFT_BRACKET)
                leftBracketCount++;
            else if (expression.charAt(i) == RIGHT_BRACKET)
                rightBracketCount++;
        }

        return (leftBracketCount == 0 && rightBracketCount == 0) || leftBracketCount > rightBracketCount;
    }
}