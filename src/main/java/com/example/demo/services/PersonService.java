package com.example.demo.services;

import com.example.demo.client.BookClient;
import com.example.demo.client.dto.BookResponse;
import com.example.demo.client.dto.VolumeInfo;
import com.example.demo.controller.dto.PersonInput;
import com.example.demo.model.Book;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private PersonRepository personRepository;
	private BookClient bookClient;

	@Autowired
	public PersonService(PersonRepository personRepository, BookClient bookClient) {
		this.personRepository = personRepository;
		this.bookClient = bookClient;
	}

	public Person createPerson(PersonInput personInput) {
		Book book = createBook(personInput.getIsbn());
		return new Person(personInput.getName(), personInput.getDni(), personInput.getAge(), book);
	}

	private Book createBook(String isbn) {
		BookResponse bookResponse = bookClient.getBookResponse(isbn);
		VolumeInfo volumeInfo = bookResponse.getItems().get(0).getVolumeInfo();
		return new Book(
				isbn,
				volumeInfo.getTitle(),
				volumeInfo.getAuthors().get(0),
				volumeInfo.getPublisher(),
				volumeInfo.getPublishedDate(),
				volumeInfo.getDescription()
		);
	}
}
