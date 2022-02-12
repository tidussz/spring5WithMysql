package com.course.springframework.persistance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="book")
public class Book extends BaseEntity {

	@Column(name="title")
	private String title;
	
	@Column(name="numOfPages")
	private Integer numOfPages;
	
	@Column(name="price")
	private Float price;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
}
