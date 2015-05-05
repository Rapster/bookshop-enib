/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.events;

import fr.enib.ihm.bookshop.domain.catalog.Category;
import java.util.EventObject;

/**
 *
 * @author yo8chapa
 */
public class CategoryEvent extends EventObject{
    private Category category;
    private int idCategory;
    
    public CategoryEvent(Object source){
        this(source, new Category(), 0); // Pas d'id spécifié : ex add
    }
    public CategoryEvent(Object source, Category cat){
        this(source, cat, 0);            // Pas d'id spécifié : ex add
    }
    public CategoryEvent(Object source, Category cat, int id){
        super(source);
        this.category = cat;
        this.idCategory = id;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category cat){
        this.category = cat;
    }

    /**
     * @return the idCategory
     */
    public int getIdCategory() {
        return idCategory;
    }
}
