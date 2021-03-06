package com.yang.service;

import com.yang.dao.BookDao;
import com.yang.model.Book;
import com.yang.model.ElectricBook;
import com.yang.model.PaperBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songyang on 8/12/14.
 */
@Service
public class BookService {
    @Autowired
    private BookDao dao;

    public List<Book> searchBooksByName(String name){
        return dao.getBooksByName(name);
    }

    public boolean addBook(Book book) {
        return dao.addBook(book);
    }

    public boolean deleteBookByIsbn(int isbn){
        return dao.deleteBookByIsbn(isbn);
    }

    public List<Book> getBooks(){
        return dao.getBooks();
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    public List<PaperBook> getPaperBooks() {
        return dao.getPaperBooks();
    }

    public List<ElectricBook> getElectricBook() {
        return dao.getElectricBooks();
    }
}
