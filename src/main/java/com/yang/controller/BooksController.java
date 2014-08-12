package com.yang.controller;

import com.yang.model.Book;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    BookService service;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showBooks(Model model) {
        model.addAttribute("books", service.getBooks());
        System.out.println(model);
        return "show";
    }

    @RequestMapping(value = "/show", params = "bookname", method = RequestMethod.GET)
    public String searchBooksByName(@RequestParam("bookname") String bookName, Model model) {
        List<Book> books = service.searchBooksByName(bookName);
        model.addAttribute("books", books);
        System.out.println(model);
        return "show";
    }

}
