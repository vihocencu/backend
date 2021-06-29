package com.ent.library.backend.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ent.library.backend.dao.Book;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
	public interface BooksRestRepository extends PagingAndSortingRepository<Book, Long> {
	    List<Book> findByTitle(@Param("title") String title);
	}
