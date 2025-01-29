package org.example;

public class Person {
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String [] books = new String[10] ;

    //constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = getSequencer();
    }

    // getters
    public static int getSequencer() {
        return sequencer++;
    }

    public int getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String [] loanedBooks (){
        return books;
    }

    //setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //other methods
    private static int getNextId() {
        return sequencer++;
    }

    public void addBokToPerson(Book bookToAdd){
        books[Library.getEmptyPlaceInList(books)] = bookToAdd.getTitle();
    }

    public void removeBookFromPerson(Book bookToRemove){
        for (int i = 0; i < books.length; i++) {
            if(bookToRemove.getTitle().equals(books[i])){
                books[i] = null;
                return;
            }
        }
    }

    public String getPersonInformation() {
        return "id: " + this.id + ", " + this.firstName + " " + this.lastName;
    }

}


