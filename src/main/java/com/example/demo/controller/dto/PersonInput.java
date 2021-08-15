package com.example.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonInput {
	private String name;
	private String dni;
	private Long age;
	private String isbn;
}
