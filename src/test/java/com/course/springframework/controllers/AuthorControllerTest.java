package com.course.springframework.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.course.springframework.services.AuthorService;

@SpringBootTest
class AuthorControllerTest {
	
	private AuthorController authorController;
	private AutoCloseable closeable;
	
	@Mock
	private AuthorService authorService;
	
	@BeforeEach
	public void setUp() {
		
		closeable = MockitoAnnotations.openMocks(this);
		
		authorController = new AuthorController(authorService);
	}
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

	@Test
	void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
		
		mockMvc.perform(get("/author/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("authors"));
	}

}
