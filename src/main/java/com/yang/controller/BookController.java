package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yang.DBCPManager;

/**
 * Created by songyang on 7/24/14.
 */
@Controller
@RequestMapping("show/books")
public class BookController {
    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", DBCPManager.select("*"));
        System.out.println(model);
        return "books";
    }
}
