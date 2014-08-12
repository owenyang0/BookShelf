package com.yang.model;

/**
 * Created by songyang on 8/12/14.
 */
public class ElectricBook extends Book {
    private String downloadUrl;

    public ElectricBook(String isbn, String name, double price, String author, String downloadUrl) {
        super(isbn, name, price, author);
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
