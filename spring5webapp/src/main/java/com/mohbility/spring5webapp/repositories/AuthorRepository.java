package com.mohbility.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mohbility.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
