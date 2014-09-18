package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by songyang on 7/24/14.
 */
@Controller
public class SampleController {
    @RequestMapping(value = "/hello")
    public String loadHomePage(Model m) {
        m.addAttribute("name", "hello yang");
        return "hello";
    }
}
