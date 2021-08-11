package com.example.jpatest.repo;

import com.example.jpatest.entity.Person;
import com.example.jpatest.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
