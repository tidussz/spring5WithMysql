package com.course.springframework.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.course.springframework.persistance.model.Book;
import com.course.springframework.persistance.repositories.BookRepository;
import com.course.springframework.services.BookService;

@Service
public class BookJpaService implements BookService {
	
	private final BookRepository bookRepository;
	
	public BookJpaService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Set<Book> findAll() {
		
		Set<Book> books = new HashSet<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book save(Book object) {
		return bookRepository.save(object);
	}

	@Override
	public void delete(Book object) {
		bookRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Set<Book> findByAuthorId(Long authorId) {
		return bookRepository.findByAuthorId(authorId);
	}
}
