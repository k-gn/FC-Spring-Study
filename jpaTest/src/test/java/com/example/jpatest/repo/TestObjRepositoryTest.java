package com.example.jpatest.repo;

import com.example.jpatest.entity.TestEntity;
import com.example.jpatest.entity.TestObj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestObjRepositoryTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    @Autowired
    private TestObjRepository testObjRepository;

    @Autowired
    EntityManager em;

    @BeforeEach
    void before() {
        TestEntity entity1 = new TestEntity();
        entity1.setName("test1");
        testEntityRepository.save(entity1);

        TestEntity entity2 = new TestEntity();
        entity2.setName("test2");
        testEntityRepository.save(entity2);

        TestObj testObj = new TestObj();
        testObj.setTestEntity(entity1);
        testObjRepository.save(testObj);

        TestObj testObj2 = new TestObj();
        testObj2.setTestEntity(entity2);
        testObjRepository.save(testObj2);
    }

    @Test
    @Transactional
    void test() {

        em.flush();
        em.clear();

        System.out.println("============================================");
//        List<TestEntity> tests = testEntityRepository.findAll();
//        TestEntity test = tests.get(0);
//        test.getTestList().forEach(t -> t.getId());
        System.out.println("============================================");
        testObjRepository.findById(1L);
//        List<TestObj> tests = testObjRepository.findAll();
//        tests.forEach(t -> t.getTestEntity().getName());
    }
}