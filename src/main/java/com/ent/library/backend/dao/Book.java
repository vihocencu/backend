package com.ent.library.backend.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	public String title;
	public String author;
	public String description;
}
