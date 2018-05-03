package com.example.a1959freetibet.hw7n8;

public class Book {

    private int id;
    private String title;
    private String author;
    private String rate;
    public Book(){}
    public Book(String title, String author, String rate) {
        super();
        this.title = title;
        this.author = author;
        this.rate = rate;
    }
    //getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public  String getRate(){
        return rate;
    }
    public void setRate(String rate){
        this.rate = rate;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author="
                + author + ", rate=" + rate + "]";
    }
}
