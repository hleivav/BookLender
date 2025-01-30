package org.example;

public class Book {
    public static int sequencer;
    private String id;
    private  String title;
    private String author;
    private boolean available;
    private Person borrower;

    //constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.id = String.valueOf(getSequencer());
        this.available = true;
        this.borrower = null;
    }

    //getters
    public static int getSequencer(){
        return ++sequencer;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower(){
        return borrower;
    }
    //setters


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setBorrower(Person borrower){
        this.borrower = borrower;
    }

    //other methods
    public String getBookInformation(){
        return "Id: " + id + ", " + "title: " + title + ", " + "author: " + author + ", " + "available: " + available;
    }
}
