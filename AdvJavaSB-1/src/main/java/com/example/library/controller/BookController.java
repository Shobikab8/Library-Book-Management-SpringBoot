package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String viewHomepg(Model model) {
		List<Book> bkList = service.listAll();
		model.addAttribute("listBook", bkList);
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("book", new Book());
		return "new";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book bk) {
		service.save(bk);
		return "redirect:/";
	}
	
	@RequestMapping("edit/{bookId}")
	public ModelAndView editBk(@PathVariable("bookId") int id) {
		ModelAndView mv = new ModelAndView("new");
		Book bk = service.get(id);
		mv.addObject("book", bk);
		return mv;
	}
	
	@RequestMapping("delete/{bookId}")
	public String deleteBk(@PathVariable("bookId") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
