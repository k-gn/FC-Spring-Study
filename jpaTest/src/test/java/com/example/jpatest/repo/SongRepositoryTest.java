package com.example.jpatest.repo;

import com.example.jpatest.entity.Person;
import com.example.jpatest.entity.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    SongRepository songRepository;
    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            Person person = Person.builder()
                    .name("person" + i)
                    .build();

            personRepository.save(person);

            Song song = Song.builder()
                    .person(person)
                    .singer("가수" + i)
                    .title("제목" + i)
                    .build();

            songRepository.save(song);
        }
    }

    @Test
    @DisplayName("n + 1 문제를 확인하는 테스트")
    @Transactional
    void findAll() {

        // give
        em.flush();
        em.clear();
        List<Song> songs = songRepository.findAll();

        // when
//        for (Song song : songs) {
//            System.out.println("person의 name에 접근 -> " + song.getPerson().getName());
//        }

        // then
        assertEquals(songs.size(), 10);
    }
}