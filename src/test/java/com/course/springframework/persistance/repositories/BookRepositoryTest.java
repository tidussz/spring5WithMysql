package com.course.springframework.persistance.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.model.Book;

@DataJpaTest
class BookRepositoryTest {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;

	@BeforeEach
	void setUp() throws Exception {
		Author author01 = new Author("Stephen", "King", new HashSet<>());
		Author author02 = new Author("Brandon", "Sanderson", new HashSet<>());
		
		Set<Book> booksAuthor01 = new HashSet<Book>();
		Set<Book> booksAuthor02 = new HashSet<Book>();
		
		Book book01 = new Book("It", 1254, 19.99f, author01);
		Book book02 = new Book("The Shinning", 875, 9.99f, author01);
		Book book03 = new Book("The Final Empire", 1105, 15.99F, author02);
		Book book04 = new Book("The Well of Ascension", 1585, 12.99F, author02);
		Book book05 = new Book("The Hero of Ages", 897, 24.99F, author02);
		
		booksAuthor01.add(book01);
		booksAuthor01.add(book02);
		booksAuthor02.add(book03);
		booksAuthor02.add(book04);
		booksAuthor02.add(book05);
		
		author01.getBooks().addAll(booksAuthor01);
		author02.getBooks().addAll(booksAuthor02);

		authorRepository.save(author01);
		authorRepository.save(author02);
	}

	@Test
	void testFindByAuthorId() {		
		
		Set<Book> book = bookRepository.findByAuthorId(1L);
		
		assertEquals(2, book.size());
	}

}
