package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dao.BookInterface;
import com.example.library.model.Book;

@Service
public class BookService {

	@Autowired
	private BookInterface dao;
	
	public void save(Book b) {
		dao.save(b);
	}
	
	public Book get(int id) {
		return dao.findById(id).get();
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public List<Book> listAll(){
		return dao.findAll();
	}
}
