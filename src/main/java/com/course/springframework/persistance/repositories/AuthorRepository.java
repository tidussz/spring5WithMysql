package com.course.springframework.persistance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.course.springframework.persistance.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
