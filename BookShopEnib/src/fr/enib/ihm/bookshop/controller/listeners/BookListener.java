/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.listeners;
import fr.enib.ihm.bookshop.controller.events.BookEvent;
import java.util.EventListener;

/**
 *
 * @author yo8chapa
 */
public interface BookListener extends EventListener {
    public void bookAdd(BookEvent ev);
    public void bookRemove(BookEvent ev);
    public void bookUpdate(BookEvent ev);
}
