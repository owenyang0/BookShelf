package com.yang.model;

/**
 * Created by songyang on 7/24/14.
 */
public class Book {
    private String isbn;
    private String name;
    private double price;
    private String author;

    public Book(String isbn, String name, double price, String author) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
