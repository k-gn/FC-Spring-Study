package com.example.jpatest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person")
    private List<Song> songs = new ArrayList<>();

    @Builder
    public Person(String name, List<Song> playList) {
        this.name = name;
        if (playList != null) {
            this.songs = playList;
        }
    }

    public void addSong(Song song) {
        this.songs.add(song);
        song.updatePerson(this);
    }
}