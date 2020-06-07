package com.company;

public class ErrorUtils {
    public static void mixedExpression() {
        throw new IllegalArgumentException("Выражение не может состоять одновременно из арабских и римских цифр");
    }

    public static void expressionNotFound() {
        throw new IllegalArgumentException("Выражение не найдено");
    }

    public static void illegalRomanianNumerals() {
        throw new IllegalArgumentException("Римские цифры введены неправильно");
    }
}
