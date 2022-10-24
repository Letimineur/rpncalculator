package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RpnServiceImpl implements RpnService{

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
        return null;
    }

    @Override
    public CalculatorStack pushToStack(final Long id, final double value) {
        return null;
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
