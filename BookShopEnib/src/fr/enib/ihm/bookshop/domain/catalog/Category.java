/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Serge Morvan
 */
public class Category implements Serializable {
    static private final long serialVersionUID = 33L;
    private int id; // 0 par défaut, 1 au minimum
    private String name;
    private String description;
    private List<Subject> subjects;

    public Category() {
        this(0, null, null, new ArrayList<Subject>() );
    }
    public Category(String name, String description){
        this(0, name, description, new ArrayList<Subject>());
    }
    public Category(String name, String description, List<Subject> subjects){
        this(0, name, description, subjects);
    }
    public Category(int id, String name, String description, List<Subject> subjects){
        this.id = id;
        this.name = name;
        this.description = description;
        this.subjects = subjects;
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
    // -- Subjects
    public List<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }
    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }
    /**
     *
     * @return string
     */
    @Override
    public String toString(){
        return new String(name);//+ " - " + description
    }

}
