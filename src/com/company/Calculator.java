package com.company;

public class Calculator {

    public static int calculate(Integer first, String symbol, Integer second) {
        switch (symbol) {
            case "+": {
                return first + second;
            }
            case "-": {
                return first - second;
            }
            case "*": {
                return first * second;
            }
            case "/": {
                return first / second;
            }
        }
        throw new IllegalArgumentException();
    }
}
