package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingPk;

    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "block_Id")
    private Long blockId;
}
