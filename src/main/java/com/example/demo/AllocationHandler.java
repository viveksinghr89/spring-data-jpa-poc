package com.example.demo;

import com.example.demo.model.Allocation;
import com.example.demo.model.Block;
import com.example.demo.model.Booking;
import com.example.demo.repository.DbStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class AllocationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllocationHandler.class);
    @Autowired
    private DbStore dbStore;

    public List<Allocation> handleRequest(String input) {
        Block block = new Block();
        block.setQuantity(new BigDecimal(1000000));

        // Persist Block
        LOGGER.info("Persist block in DB");
        block = dbStore.save(block);
        LOGGER.info("Persisted Block in DB with Id [{}]", block.getBlockPk());

        Allocation allocation = new Allocation();
        allocation.setQuantity(new BigDecimal(500000));

        block.addAllocation(allocation);
        allocation.setBlock(block);

        LOGGER.info("Persist allocation in DB");
        allocation = dbStore.save(allocation);
        LOGGER.info("Persisted allocation in DB with Id [{}]", allocation.getAllocationPk());

        LOGGER.info("Update Block");
        block = dbStore.save(block);

        Booking booking = new Booking();
        booking.setBlockId(block.getBlockPk());

        LOGGER.info("Persist booking in DB");
        booking = dbStore.save(booking);
        LOGGER.info("Persisted Booking in DB with Id [{}]", booking.getBookingPk());

        return Arrays.asList(allocation);
    }
}
