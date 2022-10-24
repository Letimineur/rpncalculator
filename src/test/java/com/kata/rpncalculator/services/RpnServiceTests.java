package com.kata.rpncalculator.services;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.repository.StackRepository;
import com.kata.rpncalculator.data.utilities.CalculatorOperator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RpnServiceTests {

    @InjectMocks
    private RpnServiceImpl rpnService;

    @Mock
    StackRepository stackRepository;

    @Test
    void applyOperatorToStack(){
        CalculatorStack testStack = new CalculatorStack();
        testStack.getValues().add(10d);
        testStack.getValues().add(5d);
        testStack.getValues().add(2d);
        when(stackRepository.findById(1l)).thenReturn(Optional.of(testStack));
        CalculatorStack resultAdd = new CalculatorStack();
        resultAdd.getValues().add(10d);
        resultAdd.getValues().add(7d);
        for (CalculatorOperator op : CalculatorOperator.values()) {
            final CalculatorStack result = rpnService.applyOperatorToStack(1l, op);
            switch (op) {
                case ADD -> Assert.isTrue(result.getValues().equals(resultAdd.getValues()));

            }
        }
    }
}
