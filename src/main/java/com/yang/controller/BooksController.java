package com.yang.controller;

import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by songyang on 8/12/14.
 */
@Controller
@RequestMapping("books/search")
public class BooksController {
    @Autowired
    BookService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", service.getBooks());
        System.out.println(model);
        return "show";
    }

}
