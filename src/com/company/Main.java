package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String expression = scanner.nextLine();
	    Matcher expressionMatcher = Pattern.compile("((10|\\d)|[IVX]{1,4}) [-+*/] ((10|\\d)|[IVX]{1,4})").matcher(expression);
	    if (!expressionMatcher.find()) ErrorUtils.expressionNotFound();
        Matcher numericMatcher = Pattern.compile("(10|\\d)").matcher(expression);
        Matcher romanMatcher = Pattern.compile("[IVX]{1,4}").matcher(expression);
        Matcher symbolMatcher = Pattern.compile("[-+*/]").matcher(expression);
        symbolMatcher.find();
        if (numericMatcher.find() && !romanMatcher.find()) {
            int first = Integer.parseInt(numericMatcher.group());
            if (numericMatcher.find(numericMatcher.end() + 1)) {
                int second = Integer.parseInt(numericMatcher.group());
                String symbol = symbolMatcher.group();
                System.out.println("Результат: " + Calculator.calculate(first, symbol, second));
            } else ErrorUtils.expressionNotFound();
        } else if (romanMatcher.find()) {
            String first = romanMatcher.group();
            if (romanMatcher.find(romanMatcher.end() + 1)) {
                String second = romanMatcher.group();
                String symbol = symbolMatcher.group();
                System.out.println("Результат: " + RomanCalculator.calculate(first, symbol, second));
            } else ErrorUtils.expressionNotFound();
        } else ErrorUtils.mixedExpression();
    }
}
