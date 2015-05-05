/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.SubjectEvent;
import fr.enib.ihm.bookshop.controller.listeners.SubjectListener;
import fr.enib.ihm.bookshop.domain.catalog.Subject;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo8chapa
 */
public class Subjects extends AbstractTableModel implements SubjectListener, Serializable{
    static private final long serialVersionUID = 33L;
    private ArrayList<Subject> subjects = null;
    private String[] columnNames = {"Id", "Name", "Description"};
    private static Subjects instance = null;
    
    /* Constructors */
    private Subjects(){
        this(new ArrayList<Subject>());
    }
    private Subjects(ArrayList<Subject> subjects){
        this.subjects = subjects;
        ApplicationEventsDispatcher.getApplicationEventsDispatcher().addSubjectListener(this);
    }    
    /* Return instance of Categories */
    public synchronized static Subjects getInstance(){
        if(instance == null) {
            instance = new Subjects();
        }
        return instance;
    }
    /* Uses' method List */
    public void addSubject(Subject s){
        s.setId(getId());
        if(s.getCategory() != null) s.getCategory().addSubject(s);
        subjects.add(s);
        this.fireTableDataChanged();
    }
    
    public void removeSubject(Subject subjectToRemove){
        if(subjectToRemove.getCategory() != null) subjectToRemove.getCategory().removeSubject(subjectToRemove);
        subjects.remove(subjectToRemove);
        this.fireTableDataChanged();
    }
    
    public void updateSubject(Subject s) {
        Subject subjectUpdated = getSubjectById(s.getId()); // Recherche du sujet à modifier
        // -- Modifications
        subjectUpdated.setName(s.getName());
        subjectUpdated.setDescription(s.getDescription());
        // -- Dans le cas d'une catégorie, il faut mettre à jour les infos de la categorie précédente.
        if(s.getCategory() != null){
            if(subjectUpdated.getCategory() != null )  subjectUpdated.getCategory().removeSubject(subjectUpdated);                         // Suppression de l'ancienne
            subjectUpdated.setCategory(s.getCategory());                                        // Ajout de la nouvelle
            s.getCategory().addSubject(subjectUpdated);                                         // Maj de la categorie correspondante
        }
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjectsList(ArrayList<Subject> subjects){
        this.subjects = subjects;
    }
    /* Implements SubjectListener */
    public void subjectAdd(SubjectEvent ev) {
        addSubject(ev.getSubject());
    }
    public void subjectRemove(SubjectEvent ev) {
        removeSubject(ev.getSubject());
    }
    public void subjectUpdate(SubjectEvent ev) {
        updateSubject(ev.getSubject());
    }
    /**
     *
     * @return id incremente
     */
    private int getId(){
        if(this.subjects.size() > 0) {
            return this.subjects.get(subjects.size()-1).getId() + 1;
        }
        else
            return 1;
    }
    public Subject getSubjectById(int id) {
        for(Subject s : this.subjects){
            if(s.getId() == id){
                return s;
            }            
        }
        return null;
    }
    /*
     * Abstracts Methods
     */

   /**
     * Méthode abstraite dans AbstractTableModel : nombre de lignes de la table
     */
    public int getRowCount() {
        return this.subjects.size();
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
        Subject sub = this.subjects.get(rowIndex);
        Object o = null;

        switch (columnIndex) {
            case 0:
                o = sub.getId();
                break;
            case 1:
                o = sub.getName();
                break;
            case 2:
                o = sub.getDescription();
                break;
        }
        return o;
    }
    /**
     * Méthode de récupération d'un subject à une ligne spécifiée dans la JTable
     * @param rowIndex
     * @return
     */
    public Subject getSubjectAtRow(int rowIndex){
        return subjects.get(rowIndex);
    }

    /**
     * Méthode appelé implicitement par l'objet ObjectInputStream lors de la désérialisation
     * Celle-ci permet d'assurer l'unicité du singleton, et non de retourner une nouvelle référence comme le fait le mécanisme de la désérialisation
     * @return instance static
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
	// récupération des données désérialisées
	ArrayList<Subject> d = getSubjects();
	// récuperation de l'instance static
	Subjects s = getInstance();
	// affectation des données désérialisées à l'instance static.
	s.setSubjectsList(d);
	// on renvoie l'instance static
	return s;
    }

}
