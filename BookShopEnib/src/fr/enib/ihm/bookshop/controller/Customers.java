/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.CustomerEvent;
import fr.enib.ihm.bookshop.controller.listeners.CustomerListener;
import fr.enib.ihm.bookshop.domain.customer.Customer;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo8chapa
 */
public class Customers extends AbstractTableModel implements CustomerListener, Serializable{
    static private final long serialVersionUID = 33L;
    private ArrayList<Customer> customers = null;
    private String[] columnNames = {"Id", "Firstname", "Lastname", "Telephone", "Email", "City", "Country"};
    private static Customers instance = null;
    
    /* Constructors */
    private Customers(){
        this(new ArrayList<Customer>());
    }
    private Customers(ArrayList<Customer> customers){
        this.customers = customers;
        ApplicationEventsDispatcher.getApplicationEventsDispatcher().addCustomerListener(this);
    }    
    /* Return instance of Categories */
    public synchronized static Customers getCustomers(){
        if(instance == null) {
            instance = new Customers();
        }
        return instance;
    }
    /* Uses' method List */
    public void addCustomer(Customer c){
        c.setId(getNewId());       
        customers.add(c);
        System.out.println("Add!");
        this.fireTableDataChanged();
    }
    
    public void removeCustomer(Customer customerToRemove){
        customers.remove(customerToRemove);
        this.fireTableDataChanged();
    }
    
    public void updateCustomer(Customer c) {
        Customer customerUpdated = getCustomerById(c.getId()); // Recherche du sujet à modifier
        // -- Modifications
        if(customerUpdated !=null){
            // -- Modification customer
            customerUpdated.setFirstName(c.getFirstName());
            customerUpdated.setLastName(c.getLastName());
            customerUpdated.setDateOfBirth(c.getDateOfBirth());
            customerUpdated.setLogin(c.getLogin());
            customerUpdated.setPassword(c.getPassword());
            customerUpdated.setTelephone(c.getTelephone());
            customerUpdated.setEmail(c.getEmail());
            //
            customerUpdated.setCreditCard(c.getCreditCard());
            customerUpdated.setAddress(c.getAddress());
        }

        
        
    }
    public ArrayList<Customer> getCustomersList() {
        return customers;
    }
    public void setCustomersList(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    /* Implements SubjectListener */
    public void customerAdd(CustomerEvent ev) {
        System.out.println("Could you add it!?");
        addCustomer(ev.getCustomer());
    }
    public void customerRemove(CustomerEvent ev) {
        removeCustomer(ev.getCustomer());
    }
    public void customerUpdate(CustomerEvent ev) {
        updateCustomer(ev.getCustomer());
    }
    /**
     *
     * @return id incremente
     */
    private int getNewId(){
        if(this.customers.size() > 0) {
            return this.customers.get(customers.size()-1).getId() + 1;
        }
        else
            return 1;
    }
    public Customer getCustomerById(int id) {
        for(Customer customer : this.customers){
            if(customer.getId() == id){
                return customer;
            }            
        }
        return null;
    }
    /**
      * Abstracts Methods
      */

    /**
     * Méthode abstraite dans AbstractTableModel : nombre de lignes de la table
     */
    public int getRowCount() {
        return this.customers.size();
    }

    /**
      * Méthode abstraite dans AbstractTableModel : nombre de colonnes de la table
      */
    public int getColumnCount() {
        return 7;
    }

    /**
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
        Customer customer = this.customers.get(rowIndex);
        Object o = null;

        switch (columnIndex) {
            case 0:
                o = customer.getId();
                break;
            case 1:
                o = customer.getFirstName();
                break;
            case 2:
                o = customer.getLastName();
                break;
            case 3:
                o = customer.getTelephone();
                break;
            case 4:
                o = customer.getEmail();
                break;
            case 5:
                o = customer.getAddress().getCity();
                break;
            case 6:
                o = customer.getAddress().getCountry();
                break;
        }
        return o;
    }
    
    /**
     * Méthode de récupération d'un customer à une ligne spécifiée dans la JTable
     * @param rowIndex
     * @return
     */
    public Customer getCustomerAtRow(int rowIndex){
        return customers.get(rowIndex);
    }

    /**
     * Méthode appelé implicitement par l'objet ObjectInputStream lors de la désérialisation
     * Celle-ci permet d'assurer l'unicité du singleton, et non de retourner une nouvelle référence comme le fait le mécanisme de la désérialisation
     * @return instance static
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
	// récupération des données désérialisées
	ArrayList<Customer> customerList = getCustomersList();
	// récuperation de l'instance static
	Customers customerInstance = getCustomers();
	// affectation des données désérialisées à l'instance static.
	customerInstance.setCustomersList(customerList);
	// on renvoie l'instance static
	return customerInstance;
    }
}
