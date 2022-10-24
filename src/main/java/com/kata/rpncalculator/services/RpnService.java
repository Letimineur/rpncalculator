package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.utilities.CalculatorOperator;
import com.kata.rpncalculator.exceptions.OperationFailedException;
import com.kata.rpncalculator.exceptions.StackNotFoundException;

import java.util.List;

public interface RpnService {

    CalculatorStack createStack();

    List<CalculatorStack> getAllStacks();

    CalculatorStack getStack(Long id) throws StackNotFoundException;

    CalculatorStack pushToStack(Long id, double value) throws StackNotFoundException;

    CalculatorStack applyOperatorToStack(Long id, CalculatorOperator op) throws StackNotFoundException, OperationFailedException;

    void deleteStack(Long id);
}
