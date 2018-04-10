package main.java.calculator;

import main.java.calculator.utils.ValidatorUtils;
import main.java.calculator.utils.CalculatorUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by K. Pendo on 02/04/2018
 * <p>
 * sqrt() & pow() - функции
 * <p>
 */
public class Main {

    public static final char LEFT_BRACKET = '(';
    public static final char RIGHT_BRACKET = ')';
    public static final char POINT = '.';

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression;

        System.out.println("Введите выражение:");

        try {

            expression = ValidatorUtils.isValidExpression(br.readLine());

            double result = CalculatorUtils.calculate(expression);
            System.out.println("Результат: " + String.valueOf(result));

        } catch (Exception exceptions) {
            System.out.println(exceptions.getMessage());
        }
    }
}
