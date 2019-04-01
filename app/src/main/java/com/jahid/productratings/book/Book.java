package com.jahid.productratings.book;

public class Book {
    String title;
    String image;

    String walmart_price;
    float walmart_rating;
    float walmart_rating_no;
    String walmart_link;

    String flipkart_price;
    float flipkart_rating;
    float flipkart_rating_no;
    String flipkart_link;


    public Book() {
    }

    public Book(String title, String image, String walmart_price, float walmart_rating,
                float walmart_rating_no, String walmart_link, String flipkart_price,
                float flipkart_rating, float flipkart_rating_no, String flipkart_link) {
        this.title = title;
        this.image = image;
        this.walmart_price = walmart_price;
        this.walmart_rating = walmart_rating;
        this.walmart_rating_no = walmart_rating_no;
        this.walmart_link = walmart_link;
        this.flipkart_price = flipkart_price;
        this.flipkart_rating = flipkart_rating;
        this.flipkart_rating_no = flipkart_rating_no;
        this.flipkart_link = flipkart_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getWalmart_rating() {
        return walmart_rating;
    }

    public void setWalmart_rating(float walmart_rating) {
        this.walmart_rating = walmart_rating;
    }

    public float getWalmart_rating_no() {
        return walmart_rating_no;
    }

    public void setWalmart_rating_no(float walmart_rating_no) {
        this.walmart_rating_no = walmart_rating_no;
    }

    public String getWalmart_link() {
        return walmart_link;
    }

    public void setWalmart_link(String walmart_link) {
        this.walmart_link = walmart_link;
    }


    public float getFlipkart_rating() {
        return flipkart_rating;
    }

    public void setFlipkart_rating(float flipkart_rating) {
        this.flipkart_rating = flipkart_rating;
    }

    public float getFlipkart_rating_no() {
        return flipkart_rating_no;
    }

    public void setFlipkart_rating_no(float flipkart_rating_no) {
        this.flipkart_rating_no = flipkart_rating_no;
    }

    public String getWalmart_price() {
        return walmart_price;
    }

    public void setWalmart_price(String walmart_price) {
        this.walmart_price = walmart_price;
    }

    public String getFlipkart_price() {
        return flipkart_price;
    }

    public void setFlipkart_price(String flipkart_price) {
        this.flipkart_price = flipkart_price;
    }

    public String getFlipkart_link() {
        return flipkart_link;
    }

    public void setFlipkart_link(String flipkart_link) {
        this.flipkart_link = flipkart_link;
    }
}
