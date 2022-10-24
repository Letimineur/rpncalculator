package com.kata.rpncalculator.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stack_id")
    private long id;

    @Column(name = "stack_values",nullable = false)
    @ElementCollection
    private List<Double> values;

    public Stack(){
        this.values = new ArrayList<>();
    }

    public void setValues(final List<Double> values) {
        this.values = values;
    }

    public long getId() {
        return id;
    }

    public List<Double> getValues() {
        return values;
    }
}
