package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;

import com.example.demo.service.BookService;


@RestController
public class BookController {
	@Autowired
	BookService bookser;
	
	
	@ GetMapping("/office")
	public List<Book> getalloff(){
		List<Book> off=bookser.getall();
		return off;
	}
	@GetMapping("/office/{id}")
	public Book getid(@PathVariable int id) {
		return  bookser.getofid(id);
		
	}
	@PostMapping("/office")
	public void saveoffice(@RequestBody Book office) {
		bookser.addoffice(office);
		
		
	}
	@PostMapping("/officers")
	public void addall(@RequestBody List<Book> office) {
		bookser.addall(office);
	}
	@PutMapping("/office/{id}")
	public void updateo(@RequestBody Book office,@PathVariable int id) {
		bookser.updateoffice(id, office.getName(),office.getAuthor(),office.getPrice());
		
		
	}
	@DeleteMapping("/office/{id}")
	public void deleteo(@PathVariable int id) {
		bookser.deleteoffice(id);
	}

}
