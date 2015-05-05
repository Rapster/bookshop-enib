/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.catalog;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Serge Morvan
 */
public class Book implements Serializable {

    private int id;
    private String title;
    private String isbn;
    private String lang;
    private Date dateOfParution;
    private String author;
    private String editor;
    private Float price;
    private String imagePath;
    private Subject subject;
    static private final long serialVersionUID = 33L;
    
    public Book() {
    }

    public Book(String title, String isbn, String lang, Date dateOfParution, String author, Float price, String imagePath) {
        this(title, isbn, lang, dateOfParution, author, null, price, imagePath, null);
    }    
    public Book(String title, String isbn, String lang, Date dateOfParution, String author,String editor, Float price, String imagePath, Subject subject) {
        this.title = title;
        this.isbn = isbn;
        this.lang = lang;
        this.dateOfParution = dateOfParution;
        this.author = author;
        this.editor = editor;
        this.price = price;
        this.imagePath = imagePath;
        this.subject = subject;
    }
    // -- Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // -- Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // -- Isbn
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // -- Lang
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }

    // -- DateOfParution
    public Date getDateOfParution() {
        return dateOfParution;
    }
    public void setDateOfParution(Date dateOfParution) {
        this.dateOfParution = dateOfParution;
    }

    // -- Author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // -- Editor
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }

    // -- Price
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    // -- ImagePath
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // -- Subject
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString(){
        return new String(title);
    }
}
