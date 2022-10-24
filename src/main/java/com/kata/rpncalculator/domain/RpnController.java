package com.kata.rpncalculator.domain;

import com.kata.rpncalculator.data.entity.CalculatorStack;
import com.kata.rpncalculator.services.RpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpn")
public class RpnController {

    @Autowired
    RpnService rpnService;

    @GetMapping("/op")
    public ResponseEntity<String> getAllOperators() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/stacks")
    public ResponseEntity<List<CalculatorStack>> getAllStack() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/stack/{id}")
    public ResponseEntity<CalculatorStack> getStackById(@PathVariable(name = "id") final Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/stack")
    public ResponseEntity<CalculatorStack> createStack() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/stack/{id}")
    public ResponseEntity<CalculatorStack> pushInStack(@PathVariable(name = "id") final Long id, @RequestBody final double value) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/op/{op}/stack/{id}")
    public ResponseEntity<CalculatorStack> applyOperator(@PathVariable(name = "id") final Long id, @PathVariable(name = "op") final String op) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/stack/{id}")
    public ResponseEntity<Void> deleteStack(@PathVariable(name = "id") final Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
