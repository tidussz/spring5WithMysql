package com.course.springframework.services.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.repositories.AuthorRepository;
import com.course.springframework.services.AuthorService;

class AuthorJpaServiceTest {
	
	private AuthorService authorService;
	
	@Mock
	private AuthorRepository authorRepository;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	public void initService() {
		closeable = MockitoAnnotations.openMocks(this);
		authorService = new AuthorJpaService(authorRepository);
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

	@Test
	void testFindAll() {
		Author author = new Author(null, null, null);
		Set<Author> authorsData = new HashSet<>();
		authorsData.add(author);
		
		when(authorRepository.findAll()).thenReturn(authorsData);
		
		Set<Author> authors = authorService.findAll();
		
		assertEquals(authors.size(), 1);
		verify(authorRepository, times(1)).findAll();
	}

}
