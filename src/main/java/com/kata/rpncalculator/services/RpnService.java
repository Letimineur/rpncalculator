package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;

import java.util.List;

public interface RpnService {

    public CalculatorStack createStack();
    public List<CalculatorStack> getAllStacks();
    public CalculatorStack getStack(Long id);
    public CalculatorStack pushToStack(Long id, double value);
    public CalculatorStack applyOperatorToStack(Long id, String op);
    public void deleteStack(Long id);
}
