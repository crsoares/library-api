package com.crsoares.libraryapi.service.impl;

import com.crsoares.libraryapi.exception.BusinessException;
import com.crsoares.libraryapi.model.entity.Book;
import com.crsoares.libraryapi.model.repository.BookRepository;
import com.crsoares.libraryapi.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if (repository.existsByIsbn(book.getIsbn())) {
            throw new BusinessException("Isbn já cadastrado.");
        }

        return repository.save(book);
    }
}
