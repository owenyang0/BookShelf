package com.yang.dao;

import com.yang.model.Book;
import com.yang.model.PaperBook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyang on 8/12/14.
 */
@Component
public class BookDao {
    public List<Book> getBooksByName(String bookname) {
        List<Book> books = new ArrayList<>();
        books.add(new PaperBook("876543212", "CLEAN CODE", 87.88, "YANG SONG", 654));
        return books;
    }

    public boolean addBook(Book book) {
        return true;
    }

    public boolean deleteBookById(int id) {
        return true;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new PaperBook("876543212", "CLEAN CODE", 87.88, "YANG SONG", 654));
        return books;

    }
}
