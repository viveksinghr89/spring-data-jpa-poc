package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @Column(name = "allocation_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allocationPk;

    @Version
    @Column(name = "version")
    private int version;

    @ManyToOne
    @JoinColumn(name = "block_pk", nullable = false)
    @Fetch(FetchMode.SELECT)
    @ToString.Exclude
    private Block block;

    @Column(name = "quantity")
    private BigDecimal quantity;
}
