package com.kata.rpncalculator.data.utilities;

import com.kata.rpncalculator.exceptions.BadOperatorException;

public enum CalculatorOperator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0d) {
            throw new RuntimeException("Divide by zero");
        }
        return a / b;
    });

    private final String symbol;
    private final DualDoubleLambda fx;

    CalculatorOperator(final String op, final DualDoubleLambda fx) {
        this.symbol = op;
        this.fx = fx;
    }

    public static CalculatorOperator getOperatorByValue(final String symbol) {
        for (final CalculatorOperator op : CalculatorOperator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new BadOperatorException("No operator found for " + symbol);
    }

    public static String printAvailableOperator() {
        final StringBuilder sb = new StringBuilder("All available operator are:");
        for (final CalculatorOperator op : CalculatorOperator.values()) {
            sb.append(" ").append(op.symbol);
        }
        return sb.toString();
    }

    public String getSymbol() {
        return this.symbol;
    }

    public DualDoubleLambda getFx() {
        return this.fx;
    }
}
