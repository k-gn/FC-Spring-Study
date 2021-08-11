package com.example.jpatest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "title"})
public class Song {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String singer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @Builder
    public Song(String title, String singer, Person person) {
        this.title = title;
        this.singer = singer;
        this.person = person;
    }

    public void updatePerson(Person person) {
        this.person = person;
    }
}
