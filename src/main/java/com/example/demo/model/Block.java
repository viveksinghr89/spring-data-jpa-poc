package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "block")
public class Block {

    @Id
    @Column(name = "block_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockPk;

    @Version
    @Column(name = "version")
    private int version;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("allocationPk")
    @Fetch(FetchMode.SELECT)
    @ToString.Exclude
    private Set<Allocation> allocations;

    @Column(name = "quantity")
    private BigDecimal quantity;

    public void addAllocation(Allocation allocation) {
        if (allocations == null) {
            allocations = new HashSet<>();
        }

        allocations.add(allocation);
    }
}
