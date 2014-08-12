package com.yang.dao;

import com.yang.model.Book;
import com.yang.model.ElectricBook;
import com.yang.model.PaperBook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by songyang on 8/12/14.
 */
@Component
public class BookDao {
    private List<Book> books = newArrayList(new PaperBook("876543212", "CLEAN CODE", 87.88, "YANG SONG", 654),
            new PaperBook("876583212", "GUIDE LINE", 66.28, "FANG", 64),
            new ElectricBook("11134134", "HOT GIRLS", 32.46, "TEST", "download link"),
            new PaperBook("831241324", "Servlet Head First", 22.34, "MARK", 222),
            new ElectricBook("11134134134", "HOBBIT", 34.56, "Charles", "download link")
    );

    public List<Book> getBooksByName(String bookname) {
        List<Book> searchedBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getName().toLowerCase().contains(bookname.toLowerCase())) {
                searchedBooks.add(book);
            }
        }

        return searchedBooks;
    }


    public boolean addBook(Book newbook) {
        if (books.contains(newbook)) {
            return false;
        }

        books.add(newbook);
        return true;
    }

    public boolean deleteBookByIsbn(int id) {
        for (Book book : books) {
            if (book.getIsbn().equals(String.valueOf(id))) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}
