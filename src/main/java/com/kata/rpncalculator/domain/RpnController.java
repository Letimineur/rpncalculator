package com.kata.rpncalculator.domain;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.data.utilities.CalculatorOperator;
import com.kata.rpncalculator.exceptions.BadOperatorException;
import com.kata.rpncalculator.exceptions.OperationFailedException;
import com.kata.rpncalculator.exceptions.StackNotFoundException;
import com.kata.rpncalculator.services.RpnService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rpn")
public class RpnController {

    private final static Logger log = LoggerFactory.getLogger(RpnController.class);

    @Autowired
    RpnService rpnService;

    @GetMapping("/op")
    public ResponseEntity<String> getAllOperators() {
        return new ResponseEntity<>(CalculatorOperator.printAvailableOperator(), HttpStatus.OK);
    }

    @GetMapping("/stacks")
    public ResponseEntity<List<CalculatorStack>> getAllStack() {
        return new ResponseEntity<>(this.rpnService.getAllStacks(), HttpStatus.OK);
    }

    @GetMapping("/stack/{id}")
    public ResponseEntity<CalculatorStack> getStackById(@PathVariable(name = "id") final Long id) {
        try {
            return new ResponseEntity<>(this.rpnService.getStack(id), HttpStatus.OK);
        } catch (final StackNotFoundException e) {
            log.warn("getStackById: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/stack")
    public ResponseEntity<CalculatorStack> createStack() {
        return new ResponseEntity<>(this.rpnService.createStack(), HttpStatus.OK);
    }

    @PostMapping("/stack/{id}")
    public ResponseEntity<CalculatorStack> pushInStack(@PathVariable(name = "id") final Long id, @RequestBody final double value) {
        try {
            return new ResponseEntity<>(this.rpnService.pushToStack(id, value), HttpStatus.OK);
        } catch (final StackNotFoundException e) {
            log.warn("pushInStack: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/op/{op}/stack/{id}")
    public ResponseEntity<CalculatorStack> applyOperator(@PathVariable(name = "id") final Long id, @PathVariable(name = "op") final String op) {
        try {
            final CalculatorOperator operator = CalculatorOperator.getOperatorByValue(op);
            return new ResponseEntity<>(this.rpnService.applyOperatorToStack(id, operator), HttpStatus.OK);
        } catch (final BadOperatorException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (final StackNotFoundException e) {
            log.warn("applyOperator: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (final OperationFailedException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, e.getMessage());
        }
    }

    @DeleteMapping("/stack/{id}")
    public ResponseEntity<Void> deleteStack(@PathVariable(name = "id") final Long id) {
        this.rpnService.deleteStack(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
