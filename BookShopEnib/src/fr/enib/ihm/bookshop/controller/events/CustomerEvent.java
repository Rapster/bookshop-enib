/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller.events;

import fr.enib.ihm.bookshop.domain.customer.Customer;
import java.util.EventObject;

/**
 *
 * @author yo8chapa
 */
public class CustomerEvent extends EventObject{
    private Customer customer;
    private int idCustomer;
    
    public CustomerEvent(Object source){
        this(source, new Customer(), 0); // Pas d'id spécifié : ex add
    }
    public CustomerEvent(Object source, Customer customer){
        this(source, customer, 0);            // Pas d'id spécifié : ex add
    }
    public CustomerEvent(Object source, Customer customer, int id){
        super(source);
        this.customer = customer;
        this.idCustomer = id;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }
}
