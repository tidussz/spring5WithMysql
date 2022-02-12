package com.course.springframework.persistance.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="author")
public class Author extends BaseEntity {

	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private Set<Book> books = new HashSet<>();
	
	public String getFullName() {
		return getSurname() + ", " + getName();
	}
}
