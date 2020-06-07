package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanCalculator {

    public static int calculate(String first, String symbol, String second) {
        int firstNum = numberFromRomanian(first);
        int secondNum = numberFromRomanian(second);
        switch (symbol) {
            case "+": {
                return firstNum + secondNum;
            }
            case "-": {
                return firstNum - secondNum;
            }
            case "*": {
                return firstNum * secondNum;
            }
            case "/": {
                return firstNum / secondNum;
            }
        }
        throw new IllegalArgumentException();
    }

    private static int numberFromRomanian(String romanian) {
        Matcher iMatcher = Pattern.compile("I{1,3}").matcher(romanian);
        boolean hasI = iMatcher.find();
        if (romanian.startsWith("I")) {
            if (romanian.endsWith("V")) {
                return 5 - (iMatcher.end() - iMatcher.start());
            } else if (romanian.endsWith("X")) {
                return 10 - (iMatcher.end() - iMatcher.start());
            } else {
                return (iMatcher.end() - iMatcher.start());
            }
        } else if (romanian.startsWith("V")) {
            int numOfI = 0;
            if (hasI) {
                numOfI = iMatcher.end() - iMatcher.start();
            }
            return 5 + numOfI;
        } else if (romanian.startsWith("X")) {
            int numOfI = 0;
            if (hasI) {
                numOfI = iMatcher.end() - iMatcher.start();
            }
            return 10 + numOfI;
        } else {
            ErrorUtils.illegalRomanianNumerals();
        }
        throw new IllegalArgumentException();
    }
}
