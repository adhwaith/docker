package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;



@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getall(){
		return bookRepo.findAll();
		
	}
	
	public Book getofid(int id) {
		return bookRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
		
	}
	
	public void addoffice(Book book) {
			bookRepo.save(book);
	}
	public void addall(List<Book> book) {
		bookRepo.saveAll(book);
	}
	
	public void updateoffice(int id,String name,String author,int price) {
		Book book=bookRepo.findById(id).orElseThrow(()->new RuntimeException("user not found"));
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		bookRepo.save(book);
	}
	public void deleteoffice(int id) {
		bookRepo.deleteById(id);
	}


}
