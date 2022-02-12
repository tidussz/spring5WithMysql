package com.course.springframework.persistance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	Book book;
	
	@BeforeEach
	public void setUp() {
		book = new Book();
	}

	@Test
	void testGetTitle() {
		String titleValue = "It";
		book.setTitle(titleValue);
		assertEquals(titleValue, book.getTitle());
	}

	@Test
	void testGetNumOfPages() {
		Integer numOfPagesValue = 343;
		book.setNumOfPages(numOfPagesValue);
		assertEquals(numOfPagesValue, book.getNumOfPages());
	}

	@Test
	void testGetPrice() {
		Float priceValue = 19.99F;
		book.setPrice(priceValue);
		assertEquals(priceValue, book.getPrice());
	}

	@Test
	void testGetAuthor() {
		Author author = new Author("Jose", "Test", null);
		book.setAuthor(author);
		assertEquals(author, book.getAuthor());
	}

	@Test
	void testGetId() {
		Long idValue = 4L;
		book.setId(idValue);
		assertEquals(idValue, book.getId());
	}

}
