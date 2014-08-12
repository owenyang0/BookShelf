package com.yang.dao;

import com.yang.model.Book;
import com.yang.model.PaperBook;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookDaoTest {

    @Test
    public void should_get_books_which_name_similar_to_input_name() throws Exception {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getBooksByName("ho");

        //then
        assertThat(books.size(), is(2));
        assertThat(books.get(0).getName(), is("HOT GIRLS"));
        assertThat(books.get(1).getName(), is("HOBBIT"));
    }

    @Test
    public void should_add_book_success_when_book_not_exist_before() throws Exception {
        BookDao bookDao = new BookDao();
        Book book = new PaperBook("8314324", "NODE JS", 202.34, "JACK", 242);

        int originalSize = bookDao.getBooks().size();
        bookDao.addBook(book);
        int currentSize = bookDao.getBooks().size();

        assertThat(currentSize, is(originalSize + 1));
    }

    @Test
    public void should_delete_success_when_given_isbn() throws Exception {
        BookDao bookDao = new BookDao();

        assertThat(bookDao.deleteBookByIsbn(11134134), is(true));
    }

    @Test
    public void should_get_all_the_books() throws Exception {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getBooks();

        //then
        assertThat(books.size(), is(5));
        assertThat(books.get(4).getName(), is("HOBBIT"));
        assertThat(books.get(3).getAuthor(), is("MARK"));
    }
}