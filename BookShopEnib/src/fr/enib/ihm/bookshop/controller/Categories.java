/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.CategoryEvent;
import fr.enib.ihm.bookshop.controller.listeners.CategoryListener;
import fr.enib.ihm.bookshop.domain.catalog.Category;
import fr.enib.ihm.bookshop.domain.catalog.Subject;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo8chapa
 */
public class Categories extends AbstractTableModel implements CategoryListener, Serializable  {
    static private final long serialVersionUID = 33L;
    private ArrayList<Category> categories = null;
    private String[] columnNames = {"Id", "Name", "Description"};
    private static Categories instance = null;
    
    /* Constructors */
    private Categories(){
        this(new ArrayList<Category>());
    }
    private Categories(ArrayList<Category> categories){
        this.categories = categories;
        ApplicationEventsDispatcher.getApplicationEventsDispatcher().addCategoryListener(this);
    }
    
    /* Return instance of Categories */
    public synchronized static Categories getInstance(){
        if(instance == null) {
            instance = new Categories();
        }
        return instance;
    }
    /* Uses' method List */
    public void addCategory(Category c){
        c.setId(getId());
        categories.add(c);
        this.fireTableDataChanged();
    }
    public void removeCategory(Category c){
        //Category c = this.getCategoryById(idSpecifie);
        categories.remove(c);
        this.fireTableDataChanged();
    }
    public void updateCategory(Category c){
        for(int i=0; i < categories.size(); i++){ 
            if(categories.get(i).getId() == c.getId()){
                categories.get(i).setName(c.getName());
                categories.get(i).setDescription(c.getDescription());
                for(Subject s : categories.get(i).getSubjects()) s.setCategory(null);
                categories.get(i).setSubjects(c.getSubjects());
                for(Subject s : categories.get(i).getSubjects()) s.setCategory(categories.get(i));
            }
        } 
    }
    public ArrayList<Category> getCategories(){
        return categories;
    }
    public void setCategoriesList(ArrayList<Category> categories) {
        this.categories = categories;
    }
    /* Implements CategoryListener */
    public void categoryAdd(CategoryEvent ev){
        System.out.println("Add category");
        addCategory(ev.getCategory());
    }
    public void categoryRemove(CategoryEvent ev){
        System.out.println("Remove category");
        removeCategory(ev.getCategory());
    }
    public void categoryUpdate(CategoryEvent ev){
        System.out.println("Update category");
        updateCategory(ev.getCategory());
    }
    /**
     *
     * @return id incremente
     */

    public int getId(){
        if(this.categories.size() > 0){
            return this.categories.get(categories.size()-1).getId() + 1;
        }
        else
            return 1;
    }
    /*
     * Abstracts Methods
     */

   /**
     * Méthode abstraite dans AbstractTableModel : nombre de lignes de la table
     */
    public int getRowCount() {
        return this.categories.size();
    }

    /**
      * Méthode abstraite dans AbstractTableModel : nombre de colonnes de la table
      */
    public int getColumnCount() {
        return 3;
    }
    /*
     * Méthode surdéfinie : Définie le titre des colonne à partir de l'attribut titreColonnes
     */
    @Override
    public String getColumnName(int col){
     return columnNames[col];
   }
     /**
     * Méthode abstraite dans AbstractTableModel : valeurs des cellules de la table
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category cat = this.categories.get(rowIndex);
        Object o = null;

        switch (columnIndex) {
            case 0:
                o = cat.getId();
                break;
            case 1:
                o = cat.getName();
                break;
            case 2:
                o = cat.getDescription();
                break;
        }
        return o;
    }
     /**
     * Méthode de récupération d'une category à une ligne spécifiée dans la JTable
     * @param rowIndex
     * @return
     */
    public Category getCategoryAtRow(int rowIndex){
        return categories.get(rowIndex);
    }

    /**
     * Méthode appelé implicitement par l'objet ObjectInputStream lors de la désérialisation
     * Celle-ci permet d'assurer l'unicité du singleton, et non de retourner une nouvelle référence comme le fait le mécanisme de la désérialisation
     * @return instance static
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
	// récupération des données désérialisées
	ArrayList<Category> categoryList = getCategories();
	// récuperation de l'instance static
	Categories categoriesInstance = getInstance();
	// affectation des données désérialisées à l'instance static.
	categoriesInstance.setCategoriesList(categoryList);
	// on renvoie l'instance static
	return categoriesInstance;
    }
}
