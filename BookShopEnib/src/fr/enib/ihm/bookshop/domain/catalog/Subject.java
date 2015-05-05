/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.catalog;

import java.io.Serializable;

/**
 *
 * @author Serge Morvan
 */
public class Subject implements Serializable{

    private int id;
    private String name;
    private String description;
    private Category category;
    static private final long serialVersionUID = 33L;

    public Subject() {
        this(0, null, null, null);
    }
    public Subject(String name, String description) {
        this(0, name, description, null);
    }
    public Subject(String name, String description, Category category) {
        this(0, name, description, category);
    }
    public Subject(int id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // -- Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // -- Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // -- Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    // -- Category
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return new String(name);
    }
}
