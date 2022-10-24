package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.repository.StackRepository;
import com.kata.rpncalculator.exceptions.StackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public CalculatorStack applyOperatorToStack(final Long id, final String op) {
        return null;
    }

    @Override
    public void deleteStack(final Long id) {
        stackRepository.deleteById(id);
    }
}
