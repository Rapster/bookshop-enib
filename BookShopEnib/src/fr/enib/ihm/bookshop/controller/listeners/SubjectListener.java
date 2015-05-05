/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.listeners;
import fr.enib.ihm.bookshop.controller.events.SubjectEvent;
import java.util.EventListener;

/**
 *
 * @author yo8chapa
 */
public interface SubjectListener extends EventListener {
    public void subjectAdd(SubjectEvent ev);
    public void subjectRemove(SubjectEvent ev);
    public void subjectUpdate(SubjectEvent ev);
}
