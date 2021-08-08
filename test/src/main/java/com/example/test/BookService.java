package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final StoreRepository storeRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

}
