/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.OrderEvent;
import fr.enib.ihm.bookshop.controller.listeners.OrderListener;
import fr.enib.ihm.bookshop.domain.order.Order;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo8chapa
 */
public class Orders extends AbstractTableModel implements OrderListener, Serializable{
    static private final long serialVersionUID = 33L;
    private ArrayList<Order> orderList = null;
    private String[] columnNames = {"Id", "Customer",};
    private static Orders instance = null;
    
    /* Constructors */
    private Orders(){
        this(new ArrayList<Order>());
    }
    private Orders(ArrayList<Order> orderList){
        this.orderList = orderList;
        ApplicationEventsDispatcher.getApplicationEventsDispatcher().addOrderListener(this);
    }    
    /* Return instance of Categories */
    public synchronized static Orders getInstance(){
        if(instance == null) {
            instance = new Orders();
        }
        return instance;
    }
    /* Uses' method List */
    public void addOrder(Order order){
        order.setId(getNewId());
        orderList.add(order);
        this.fireTableDataChanged();
    }
    
    public void removeOrder(Order order){
        orderList.remove(order);
        this.fireTableDataChanged();
    }
    
    public void updateOrder(Order order) {
        Order orderUpdated = getSubjectById(order.getId()); // Recherche du sujet à modifier
        if(orderUpdated != null){
            // -- Modifications
            orderUpdated.setCreditCard(order.getCreditCard());
            orderUpdated.setDeliveryAddress(order.getDeliveryAddress());
            orderUpdated.setCustomer(order.getCustomer());
            orderUpdated.setOrderDate(order.getOrderDate());
            orderUpdated.setOrderLines(order.getOrderLines());
        }
    }
    public ArrayList<Order> getOrders() {
        return orderList;
    }
    public void setOrdersList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    /* Implements SubjectListener */
    public void orderAdd(OrderEvent ev) {
        addOrder(ev.getOrder());
    }
    public void orderRemove(OrderEvent ev) {
        removeOrder(ev.getOrder());
    }
    public void orderUpdate(OrderEvent ev) {
        updateOrder(ev.getOrder());
    }
    /**
     *
     * @return id incremente
     */
    private int getNewId(){
        if(this.orderList.size() > 0) {
            return this.orderList.get(orderList.size()-1).getId() + 1;
        }
        else
            return 1;
    }
    public Order getSubjectById(int id) {
        for(Order order : this.orderList){
            if(order.getId() == id){
                return order;
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
        return this.orderList.size();
    }

    /**
      * Méthode abstraite dans AbstractTableModel : nombre de colonnes de la table
      */
    public int getColumnCount() {
        return 2;
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
        Order order = this.orderList.get(rowIndex);
        Object o = null;

        switch (columnIndex) {
            case 0:
                o = order.getId();
                break;
            case 1:
                o = order.getCustomer();
                break;
        }
        return o;
    }
    /**
     * Méthode de récupération d'un order à une ligne spécifiée dans la JTable
     * @param rowIndex
     * @return
     */
    public Order getOrderAtRow(int rowIndex){
        return orderList.get(rowIndex);
    }

    /**
     * Méthode appelé implicitement par l'objet ObjectInputStream lors de la désérialisation
     * Celle-ci permet d'assurer l'unicité du singleton, et non de retourner une nouvelle référence comme le fait le mécanisme de la désérialisation
     * @return instance static
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
	// récupération des données désérialisées
	ArrayList<Order> ordersList = getOrders();
	// récuperation de l'instance static
	Orders orderInstance = getInstance();
	// affectation des données désérialisées à l'instance static.
	orderInstance.setOrdersList(ordersList);
	// on renvoie l'instance static
	return orderInstance;
    }
}
