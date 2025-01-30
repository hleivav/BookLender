package org.example;

import java.util.Arrays;

public class Library {
    private int bookId = 0;
    private Book [] library = new Book[10];


    public Book[] getLibrary(){
        return library;
    }

    public void addBook(Book newBook){
        library[getEmptyPlaceInList(getLibrary())] = newBook;
    }

    public int getBookId(){
        return ++bookId;
    }

    public static String [] expandArray(String [] loanedBooks){
        return Arrays.copyOf(loanedBooks, loanedBooks.length + 1);
    }

    public static String [] shrinkArray(String [] loanedBooks) {
        String [] tempArray = new String[loanedBooks.length - 1];
        int counter = 0;
        for (String element : loanedBooks){
            tempArray[counter] = element;
            counter++;
        }
        return tempArray;
    }

    public  static int getEmptyPlaceInList (Book [] tempArray){
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == null){
                return i;
            }
        }
        return -1;
    }

    public  static int getEmptyPlaceInList (String [] tempArray){
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void loanBook(Book bookToLoan, Person borrower){
        if ( bookToLoan.isAvailable()){
            // the book is not longer available
            bookToLoan.setAvailable(false);
            // the book belongs to a borrower
            bookToLoan.setBorrower(borrower);
            // the borrower has a new book in its list.
            borrower.addBokToPerson(bookToLoan);
        }
    }

    public void returnBook(Book bookToReturn, Person borrower){
        //no need to check if is available when the book is in the persons list.
        //make the book available
        bookToReturn.setAvailable(true);
        //remove the book from the borrower's list
        borrower.removeBookFromPerson(bookToReturn);

    }
}
