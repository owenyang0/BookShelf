package com.yang.controller;

import com.yang.model.Book;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by songyang on 8/12/14.
 */
@Controller
@RequestMapping("books")
public class BooksController {
    public static final String PAPER_TYPE = "paper";
    public static final String ELECTRIC_TYPE = "electric";
    @Autowired
    BookService service;


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showBooks(Model model) {
        model.addAttribute("books", service.getBooks());
        System.out.println(model);
        return "books/show";
    }

    @RequestMapping(value = "/show/paper", method = RequestMethod.GET)
    public String showPaperBooks(Model model) {
        model.addAttribute("books", service.getPaperBooks());
        model.addAttribute("type", PAPER_TYPE);
        System.out.println(model);
        return "books/show";
    }

    @RequestMapping(value = "/show/electric", method = RequestMethod.GET)
    public String showElectricBooks(Model model) {
        model.addAttribute("books", service.getElectricBook());
        model.addAttribute("type", ELECTRIC_TYPE);
        System.out.println(model);
        return "books/show";
    }

    @RequestMapping(value = "/show", params = "bookname", method = RequestMethod.GET)
    public String searchBooksByName(@RequestParam("bookname") String bookName, Model model) {
        List<Book> books = service.searchBooksByName(bookName);
        model.addAttribute("books", books);
        System.out.println(model);
        return "books/show";
    }

    @RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteBookByIsbn(@PathVariable("isbn") int isbn, Model model) {
        service.deleteBookByIsbn(isbn);
        model.addAttribute("books", service.getBooks());
        System.out.println(model);
        return "books/show";
    }

}
