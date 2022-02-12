package com.course.springframework.services;

import java.util.Set;

import com.course.springframework.persistance.model.Book;

public interface BookService extends CrudService<Book, Long> {

	Set<Book> findByAuthorId(Long authorId);
}
