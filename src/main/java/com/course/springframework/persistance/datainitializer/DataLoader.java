package com.course.springframework.persistance.datainitializer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.model.Book;
import com.course.springframework.services.AuthorService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class DataLoader implements CommandLineRunner {
	
	private final AuthorService authorService;
	
	public DataLoader(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Load data for test database");
		
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

		authorService.save(author01);
		authorService.save(author02);
	}
	
	
}
