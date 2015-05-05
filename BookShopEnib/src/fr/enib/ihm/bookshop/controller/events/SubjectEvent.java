/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.events;

import fr.enib.ihm.bookshop.domain.catalog.Subject;
import java.util.EventObject;

/**
 *
 * @author yo8chapa
 */
public class SubjectEvent extends EventObject{
    private Subject subject;
    private int idSubject;
    
    public SubjectEvent(Object source){
        this(source, new Subject(), 0); // Pas d'id spécifié : ex add
    }
    public SubjectEvent(Object source, Subject sub){
        this(source, sub, 0);            // Pas d'id spécifié : ex add
    }
    public SubjectEvent(Object source, Subject sub, int id){
        super(source);
        this.subject = sub;
        this.idSubject = id;
    }
    public Subject getSubject(){
        return subject;
    }
    public void setSubject(Subject sub){
        this.subject = sub;
    }
    public int getIdSubject() {
        return idSubject;
    }
}
