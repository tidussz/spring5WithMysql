package com.course.springframework.persistance.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.course.springframework.persistance.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Set<Book> findByAuthorId(Long authorId);
}
