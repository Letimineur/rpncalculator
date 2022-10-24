package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.exceptions.StackNotFoundException;

import java.util.List;

public interface RpnService {

    public CalculatorStack createStack();
    public List<CalculatorStack> getAllStacks();
    public CalculatorStack getStack(Long id) throws StackNotFoundException;
    public CalculatorStack pushToStack(Long id, double value) throws StackNotFoundException;
    public CalculatorStack applyOperatorToStack(Long id, String op);
    public void deleteStack(Long id);
}
