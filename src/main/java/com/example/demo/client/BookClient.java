package com.example.demo.client;

import com.example.demo.client.dto.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookClient {

	private RestTemplate restTemplate;
	@Value("${books.host}")
	private String host;

	public BookClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public BookResponse getBookResponse(String isbn) {
		String url = host + "/books/v1/volumes?q=isbn:" + isbn;
		return restTemplate.getForObject(url, BookResponse.class);
	}
}
