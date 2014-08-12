package com.yang.model;

/**
 * Created by songyang on 8/12/14.
 */
public class PaperBook extends Book {
    private int pages;

    public PaperBook(String isbn, String name, double price, String author, int pages) {
        super(isbn, name, price, author);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
