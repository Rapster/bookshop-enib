/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.order;

import fr.enib.ihm.bookshop.domain.catalog.Book;
import java.io.Serializable;

/**
 *
 * @author Serge Morvan
 */
public class OrderLine implements Serializable{

    private Integer quantity;
    private Book book;
    static private final long serialVersionUID = 33L;
    
    public OrderLine() {
    }

    public OrderLine(Integer quantity, Book book) {
        this.quantity = quantity;
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString(){
        return new String(book + " (" + quantity+")");
    }
}
