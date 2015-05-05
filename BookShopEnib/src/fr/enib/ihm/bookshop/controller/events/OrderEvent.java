/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.events;

import fr.enib.ihm.bookshop.domain.order.Order;
import java.util.EventObject;

/**
 *
 * @author yo8chapa
 */
public class OrderEvent extends EventObject{
    private Order order;
    private int idOrder;
    
    public OrderEvent(Object source){
        this(source, new Order(), 0); 
    }
    public OrderEvent(Object source, Order order){
        this(source, order, 0);            
    }
    public OrderEvent(Object source, Order order, int id){
        super(source);
        this.order = order;
        this.idOrder = id;
    }
    public Order getOrder(){
        return order;
    }
    public void setOrder(Order order){
        this.order = order;
    }
    public int getIdOrder() {
        return idOrder;
    }
}
