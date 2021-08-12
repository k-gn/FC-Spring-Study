package com.example.jpatest.repo;

import com.example.jpatest.entity.TestEntity;
import com.example.jpatest.entity.TestObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestObjRepository extends JpaRepository<TestObj, Long> {
}
