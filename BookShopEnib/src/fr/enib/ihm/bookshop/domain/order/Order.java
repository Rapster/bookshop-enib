/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.order;

import fr.enib.ihm.bookshop.domain.customer.Address;
import fr.enib.ihm.bookshop.domain.customer.CreditCard;
import fr.enib.ihm.bookshop.domain.customer.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Serge Morvan
 */
public class Order implements Serializable{

    private int id;
    private Date orderDate;
    private Customer customer;
    private Address deliveryAddress;
    private CreditCard creditCard = new CreditCard();
    private List<OrderLine> orderLines;
    static private final long serialVersionUID = 33L;

    public Order() {
        orderLines = new ArrayList<OrderLine>();
    }

    public Order(Date orderDate, Customer customer, Address deliveryAddress, List<OrderLine> orderLines) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
        this.orderLines = orderLines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

}
