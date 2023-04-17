package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    @Autowired
    private AllocationHandler allocationHandler;

    public void transform(String input) {
        allocationHandler.handleRequest(input);
    }
}
