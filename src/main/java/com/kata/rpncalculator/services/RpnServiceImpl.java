package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.repository.StackRepository;
import com.kata.rpncalculator.data.utilities.CalculatorOperator;
import com.kata.rpncalculator.exceptions.OperationFailedException;
import com.kata.rpncalculator.exceptions.StackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RpnServiceImpl implements RpnService {

    @Autowired
    StackRepository stackRepository;

    @Override
    public CalculatorStack createStack() {
        return stackRepository.save(new CalculatorStack());
    }

    @Override
    public List<CalculatorStack> getAllStacks() {
        return (List<CalculatorStack>) stackRepository.findAll();
    }

    @Override
    public CalculatorStack getStack(final Long id) {
        final Optional<CalculatorStack> optionalCalculatorStack = stackRepository.findById(id);
        if (optionalCalculatorStack.isPresent()) {
            return optionalCalculatorStack.get();
        }
        throw new StackNotFoundException("No Stack found for this id: " + id);
    }

    @Override
    public CalculatorStack pushToStack(final Long id, final double value) {
        final CalculatorStack stackToUpdate = getStack(id);
        stackToUpdate.getValues().add(value);
        return stackRepository.save(stackToUpdate);
    }

    @Override
    public CalculatorStack applyOperatorToStack(final Long id, final CalculatorOperator op) {
        final CalculatorStack stack = getStack(id);
        final List<Double> values = stack.getValues();
        final Optional<Double> calc = values.stream().skip(values.size() - 2).reduce((a, b) -> op.getFx().calc(a, b));
        if (!calc.isPresent()) {
            throw new OperationFailedException("Failed to execute operator " + op.getSymbol() + " for stack id " + id);
        }
        stack.setValues(values.stream().limit(values.size() - 2).collect(Collectors.toList()));
        stack.getValues().add(calc.get());
        return stackRepository.save(stack);
    }

    @Override
    public void deleteStack(final Long id) {
        stackRepository.deleteById(id);
    }
}
