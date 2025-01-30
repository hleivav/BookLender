package org.example;

public class Person {
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String [] books = new String[1] ;

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

    private int getId() {
        return this.id;
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

    public String getPersonInformation() {
        return "id: " + this.id + ", " + this.firstName + " " + this.lastName;
    }

    //setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //other methods


    public void addBokToPerson(Book bookToAdd){
        //calls a method that returns -1 in case there's not space left. Otherwise, put a new title in the list.
        //when no space left, a new method calls to make more space.
        int nextEmptyPlaceInList = Library.getEmptyPlaceInList(books);
        if (nextEmptyPlaceInList > -1){
            books[nextEmptyPlaceInList] = bookToAdd.getTitle();
        } else {
            books =  Library.expandArray(books);
            books[books.length - 1] = bookToAdd.getTitle();
        }
    }

    public void removeBookFromPerson(Book bookToRemove){
        //when title is removed a new method is called to shrink the array with one position and move the titles in the array.
        for (int i = 0; i < books.length; i++) {
            if(bookToRemove.getTitle().equals(books[i])){
                books[i] = null;
                return;
            }
        }
        books = Library.shrinkArray(books);
    }



}


