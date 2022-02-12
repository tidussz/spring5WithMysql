package com.course.springframework.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.course.springframework.persistance.model.Author;
import com.course.springframework.persistance.repositories.AuthorRepository;
import com.course.springframework.services.AuthorService;

@Service
public class AuthorJpaService implements AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public AuthorJpaService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public Set<Author> findAll() {
		
		Set<Author> authors = new HashSet<>();
		authorRepository.findAll().forEach(authors::add);
		return authors;
	}

	@Override
	public Author findById(Long id) {
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	public Author save(Author object) {
		return authorRepository.save(object);
	}

	@Override
	public void delete(Author object) {
		authorRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		authorRepository.deleteById(id);
	}
}
