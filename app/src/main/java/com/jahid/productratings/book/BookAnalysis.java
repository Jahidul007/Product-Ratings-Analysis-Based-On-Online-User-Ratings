package com.jahid.productratings.book;

import java.util.Objects;

public class BookAnalysis {

    String title;
    String author;
    String boibazar_noOfRated;
    String boibazar_price;
    String boibazarRating;
    String boibazar_url;
    String image;
    String rokomari_noOfrated;
    String rokomari_price;
    String rokomari_rating;
    String rokomari_url;
    int score;

    public BookAnalysis() {
    }

    public BookAnalysis(String title, String author, String boibazar_noOfRated,
                        String boibazar_price, String boibazarRating, String boibazar_url,
                        String image, String rokomari_noOfrated, String rokomari_price,
                        String rokomari_rating, String rokomari_url, int score) {
        this.title = title;
        this.author = author;
        this.boibazar_noOfRated = boibazar_noOfRated;
        this.boibazar_price = boibazar_price;
        this.boibazarRating = boibazarRating;
        this.boibazar_url = boibazar_url;
        this.image = image;
        this.rokomari_noOfrated = rokomari_noOfrated;
        this.rokomari_price = rokomari_price;
        this.rokomari_rating = rokomari_rating;
        this.rokomari_url = rokomari_url;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBoibazar_noOfRated() {
        return boibazar_noOfRated;
    }

    public void setBoibazar_noOfRated(String boibazar_noOfRated) {
        this.boibazar_noOfRated = boibazar_noOfRated;
    }

    public String getBoibazar_price() {
        return boibazar_price;
    }

    public void setBoibazar_price(String boibazar_price) {
        this.boibazar_price = boibazar_price;
    }

    public String getBoibazarRating() {
        return boibazarRating;
    }

    public void setBoibazarRating(String boibazarRating) {
        this.boibazarRating = boibazarRating;
    }

    public String getBoibazar_url() {
        return boibazar_url;
    }

    public void setBoibazar_url(String boibazar_url) {
        this.boibazar_url = boibazar_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRokomari_noOfrated() {
        return rokomari_noOfrated;
    }

    public void setRokomari_noOfrated(String rokomari_noOfrated) {
        this.rokomari_noOfrated = rokomari_noOfrated;
    }

    public String getRokomari_price() {
        return rokomari_price;
    }

    public void setRokomari_price(String rokomari_price) {
        this.rokomari_price = rokomari_price;
    }

    public String getRokomari_rating() {
        return rokomari_rating;
    }

    public void setRokomari_rating(String rokomari_rating) {
        this.rokomari_rating = rokomari_rating;
    }

    public String getRokomari_url() {
        return rokomari_url;
    }

    public void setRokomari_url(String rokomari_url) {
        this.rokomari_url = rokomari_url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAnalysis that = (BookAnalysis) o;
        return score == that.score &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(boibazar_noOfRated, that.boibazar_noOfRated) &&
                Objects.equals(boibazar_price, that.boibazar_price) &&
                Objects.equals(boibazarRating, that.boibazarRating) &&
                Objects.equals(boibazar_url, that.boibazar_url) &&
                Objects.equals(image, that.image) &&
                Objects.equals(rokomari_noOfrated, that.rokomari_noOfrated) &&
                Objects.equals(rokomari_price, that.rokomari_price) &&
                Objects.equals(rokomari_rating, that.rokomari_rating) &&
                Objects.equals(rokomari_url, that.rokomari_url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author, boibazar_noOfRated, boibazar_price, boibazarRating, boibazar_url, image, rokomari_noOfrated, rokomari_price, rokomari_rating, rokomari_url, score);
    }

    @Override
    public String toString() {
        return "BookAnalysis{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", boibazar_noOfRated='" + boibazar_noOfRated + '\'' +
                ", boibazar_price='" + boibazar_price + '\'' +
                ", boibazarRating='" + boibazarRating + '\'' +
                ", boibazar_url='" + boibazar_url + '\'' +
                ", image='" + image + '\'' +
                ", rokomari_noOfrated='" + rokomari_noOfrated + '\'' +
                ", rokomari_price='" + rokomari_price + '\'' +
                ", rokomari_rating='" + rokomari_rating + '\'' +
                ", rokomari_url='" + rokomari_url + '\'' +
                ", score=" + score +
                '}';
    }
}