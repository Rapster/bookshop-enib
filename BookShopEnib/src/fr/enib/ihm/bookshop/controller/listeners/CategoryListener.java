/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.listeners;
import fr.enib.ihm.bookshop.controller.events.CategoryEvent;
import java.util.EventListener;

/**
 *
 * @author yo8chapa
 */
public interface CategoryListener extends EventListener {
    public void categoryAdd(CategoryEvent ev);
    public void categoryRemove(CategoryEvent ev);
    public void categoryUpdate(CategoryEvent ev);
}
