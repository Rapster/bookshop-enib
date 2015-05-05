/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.listeners;
import fr.enib.ihm.bookshop.controller.events.OrderEvent;
import java.util.EventListener;

/**
 *
 * @author yo8chapa
 */
public interface OrderListener extends EventListener {
    public void orderAdd(OrderEvent ev);
    public void orderRemove(OrderEvent ev);
    public void orderUpdate(OrderEvent ev);
}
