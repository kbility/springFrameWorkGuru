package com.mohbility.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mohbility.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
