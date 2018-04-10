package main.java.calculator.utils;


import main.java.calculator.models.TypedSymbols;

import java.util.ArrayList;

import static main.java.calculator.utils.TypeUtils.*;
import static main.java.calculator.Main.*;

public abstract class CalculatorUtils {

    public static double calculate(String expression) {

        ArrayList<TypedSymbols> list = formatSymbols(getTypedSymbols(expression));

        return count(list, expression.contains(String.valueOf(LEFT_BRACKET)));
    }

    private static ArrayList<TypedSymbols> formatSymbols(ArrayList<TypedSymbols> list) {
        ArrayList<TypedSymbols> result = new ArrayList<>();
        StringBuilder tempNumber = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            if ((list.get(i).getType().equals(TYPE_DIGIT) || list.get(i).getType().equals(TYPE_POINT)) ||
                    (i == 0 && list.get(i).getType().equals(TYPE_MATH_SIGN_MINUS))) {
                tempNumber.append(list.get(i).getValue());

            } else {

                if (tempNumber.length() != 0) {
                    result.add(new TypedSymbols(tempNumber.toString(), TYPE_NUMBER));
                    tempNumber.setLength(0);
                }
                result.add(new TypedSymbols(list.get(i).getValue(), list.get(i).getType()));
            }
        }

        if (tempNumber.length() != 0) {
            result.add(new TypedSymbols(tempNumber.toString(), TYPE_NUMBER));
        }

        return result;
    }

    private static double count(ArrayList<TypedSymbols> list, boolean hasBrackets) {

        if (hasBrackets) {
            return countNumbersWithBrackets(list);
        } else {
            return countNumbers(list);
        }
    }


    private static double countNumbers(ArrayList<TypedSymbols> list) {
        double result = 0;

        for (int i = 0; i < list.size(); i += 2) {
            if (i < list.size() - 1)
                switch (list.get(i + 1).getValue()) {
                    case SYMBOL_PLUS: {
                        if (i == 0) result += (list.get(i).getNumericValue() + list.get(i + 2).getNumericValue());
                        else result += list.get(i + 2).getNumericValue();
                    }
                    break;
                    case SYMBOL_MINUS: {
                        if (i == 0) result += (list.get(i).getNumericValue() - list.get(i + 2).getNumericValue());
                        else result -= list.get(i + 2).getNumericValue();
                    }
                    break;
                    case SYMBOL_MULTIPLE: {
                        if (i == 0) result += (list.get(i).getNumericValue() * list.get(i + 2).getNumericValue());
                        else result *= list.get(i + 2).getNumericValue();
                    }
                    break;
                    case SYMBOL_DIV: {
                        if (i == 0) result += (list.get(i).getNumericValue() / list.get(i + 2).getNumericValue());
                        else result /= list.get(i + 2).getNumericValue();
                    }
                    break;
                }
        }
        return result;
    }

    private static double countNumbersWithBrackets(ArrayList<TypedSymbols> list) {


        return 0;
    }
}