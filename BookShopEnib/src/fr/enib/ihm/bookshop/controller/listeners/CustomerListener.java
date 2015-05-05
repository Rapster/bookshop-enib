/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.listeners;
import fr.enib.ihm.bookshop.controller.events.CustomerEvent;
import java.util.EventListener;

/**
 *
 * @author yo8chapa
 */
public interface CustomerListener extends EventListener {
    public void customerAdd(CustomerEvent ev);
    public void customerRemove(CustomerEvent ev);
    public void customerUpdate(CustomerEvent ev);
}
