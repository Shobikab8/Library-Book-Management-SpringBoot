package com.example.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;

public interface BookInterface extends JpaRepository<Book, Integer>{

}
