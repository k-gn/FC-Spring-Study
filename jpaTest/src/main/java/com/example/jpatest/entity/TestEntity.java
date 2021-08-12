package com.example.jpatest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "testEntity")
//    @JoinColumn(name = "test_id")
    @ToString.Exclude
    private List<TestObj> testList = new ArrayList<>();;
}