/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.events;

import fr.enib.ihm.bookshop.domain.catalog.Book;
import java.util.EventObject;

/**
 *
 * @author yo8chapa
 */
public class BookEvent extends EventObject{
    private Book book;
    private int idBook;
    
    public BookEvent(Object source){
        this(source, new Book(), 0); // Pas d'id spécifié : ex add
    }
    public BookEvent(Object source, Book book){
        this(source, book, 0);            // Pas d'id spécifié : ex add
    }
    public BookEvent(Object source, Book book, int id){
        super(source);
        this.book = book;
        this.idBook = id;
    }
    public Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book = book;
    }

    public int getIdBook() {
        return idBook;
    }
}
