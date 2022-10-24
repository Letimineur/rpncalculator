package com.kata.rpncalculator.data.repository;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import org.springframework.data.repository.CrudRepository;

public interface StackRepository extends CrudRepository<CalculatorStack, Long> {
}
