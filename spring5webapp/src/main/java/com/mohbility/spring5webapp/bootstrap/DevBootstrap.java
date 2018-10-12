package com.mohbility.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mohbility.spring5webapp.model.Author;
import com.mohbility.spring5webapp.model.Book;
import com.mohbility.spring5webapp.model.Publisher;
import com.mohbility.spring5webapp.repositories.AuthorRepository;
import com.mohbility.spring5webapp.repositories.BookRepository;
import com.mohbility.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		
		Publisher publisher1 = new Publisher("Harper Collins", "971 Grant Street");
		publisherRepository.save(publisher1);
		Author eric = new Author("Eric", "Evans"); 
		Book ddd = new Book("Domain Driven Design", "1234", publisher1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Publisher publisher2 = new Publisher("worx", "12 James Street");
		publisherRepository.save(publisher2);
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
		rod.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
}
