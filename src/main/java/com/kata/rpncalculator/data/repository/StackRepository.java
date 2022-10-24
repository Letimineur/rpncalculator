package com.kata.rpncalculator.data.repository;

import com.kata.rpncalculator.data.entity.Stack;
import org.springframework.data.repository.CrudRepository;

public interface StackRepository extends CrudRepository<Stack, Long> {
}
