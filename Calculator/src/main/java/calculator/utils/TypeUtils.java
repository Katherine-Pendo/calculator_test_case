package main.java.calculator.utils;

import main.java.calculator.models.TypedSymbols;

import java.util.ArrayList;

import static main.java.calculator.Main.*;

public abstract class TypeUtils {

    public static final String SYMBOL_PLUS = "+";
    public static final String SYMBOL_MINUS = "-";
    public static final String SYMBOL_MULTIPLE = "*";
    public static final String SYMBOL_DIV = "/";

    public static final String TYPE_DIGIT = "TYPE_DIGIT";
    public static final String TYPE_MATH_SIGN = "TYPE_MATH_SIGN";
    public static final String TYPE_MATH_SIGN_MINUS = "TYPE_MATH_SIGN_MINUS";
    public static final String TYPE_BRACKET_LEFT = "TYPE_BRACKET_LEFT";
    public static final String TYPE_BRACKET_RIGHT = "TYPE_BRACKET_RIGHT";
    public static final String TYPE_POW_START = "TYPE_POW_START";
    public static final String TYPE_SQRT_START = "TYPE_SQRT_START";
    public static final String TYPE_POINT = "TYPE_POINT";

    public static final String TYPE_NUMBER = "TYPE_NUMBER";

    /**
     * @return Тип знака:
     * 1) любой арифметический
     * 2) арифметический минус
     * 3) точка
     * 4) скобки
     */
    public static String getSignType(char character) {
        switch (character) {
            case LEFT_BRACKET: {
                return TYPE_BRACKET_LEFT;
            }
            case RIGHT_BRACKET: {
                return TYPE_BRACKET_RIGHT;
            }
            case POINT: {
                return TYPE_POINT;
            }
            default: {
                if (character == '-')
                    return TYPE_MATH_SIGN_MINUS;
                else
                    return TYPE_MATH_SIGN;
            }
        }
    }

    /**
     * Метод формирует динамический массив типов выражения
     */
    public static ArrayList<String> getArrayOfTypes(String expression) {
        String type;
        ArrayList<String> arrayOfTypes = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                type = TYPE_DIGIT;
            } else if (Character.isLetter(character)) {

                int j = getFuncOffset(i, expression);
                type = (j - i) == 3 ? TYPE_POW_START : TYPE_SQRT_START;
                i = j;

            } else {
                type = getSignType(character);
            }

            arrayOfTypes.add(type);
        }
        return arrayOfTypes;
    }

    public static ArrayList<TypedSymbols> getTypedSymbols(String expression) {
        String type;

        ArrayList<TypedSymbols> typedSymbolsList = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                type = TYPE_DIGIT;
            } else if (Character.isLetter(character)) {

                int j = getFuncOffset(i, expression);
                type = (j - i) == 3 ? TYPE_POW_START : TYPE_SQRT_START;
                i = j;

            } else {
                type = getSignType(character);
            }

            typedSymbolsList.add(new TypedSymbols(String.valueOf(character), type));
        }
        return typedSymbolsList;
    }

    /**
     * Если функция является sqrt() либо pow(), возвращаем индекс с учетом смещения, иначе -1
     */
    private static int getFuncOffset(int start, String expression) {

        int size = (expression.charAt(start) == 's' ? 5 : 4) + start;

        return size - 1;
    }
}