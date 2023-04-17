package com.example.demo.repository;

import com.example.demo.model.Allocation;
import com.example.demo.model.Block;
import com.example.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DbStore {
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private AllocationRepository allocationRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public Block save(Block block) {
        return blockRepository.save(block);
    }

    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
}
