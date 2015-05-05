/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.BookEvent;
import fr.enib.ihm.bookshop.controller.events.CategoryEvent;
import fr.enib.ihm.bookshop.controller.events.CustomerEvent;
import fr.enib.ihm.bookshop.controller.events.OrderEvent;
import fr.enib.ihm.bookshop.controller.events.SubjectEvent;
import fr.enib.ihm.bookshop.controller.listeners.BookListener;
import fr.enib.ihm.bookshop.controller.listeners.CategoryListener;
import fr.enib.ihm.bookshop.controller.listeners.CustomerListener;
import fr.enib.ihm.bookshop.controller.listeners.OrderListener;
import fr.enib.ihm.bookshop.controller.listeners.SubjectListener;
import java.util.ArrayList;

/**
 *
 * @author yo8chapa
 */
public class ApplicationEventsDispatcher {
    private static ApplicationEventsDispatcher instance = null;
    private static ArrayList<CategoryListener> categoryListeners = null;
    private static ArrayList<SubjectListener> subjectListeners = null;
    private static ArrayList<BookListener> bookListeners = null;
    private static ArrayList<CustomerListener> customerListeners = null;
    private static ArrayList<OrderListener> orderListeners = null;

    private ApplicationEventsDispatcher(){
        /* Lists */
        categoryListeners = new ArrayList<CategoryListener>();  
        subjectListeners = new ArrayList<SubjectListener>();
        bookListeners = new ArrayList<BookListener>();
        customerListeners = new ArrayList<CustomerListener>();
        orderListeners = new ArrayList<OrderListener>();
    }
    /* Return instance of ApplicationEventsDispatcher */
    public synchronized static ApplicationEventsDispatcher getApplicationEventsDispatcher(){
        if(instance == null) {
            instance = new ApplicationEventsDispatcher();           
        }
        return instance;
    }
    
    /* 
     * BookAddEvent
     */
    public void addBookListener(BookListener l){        // Add a BookListener
        bookListeners.add(l);
    }
    public void removeBookListener(BookListener l){     // Remove a BookListener
        bookListeners.remove(l);
    }
    public void fireAddBookEvent(BookEvent ev){         // Fire add event
        for(BookListener l : bookListeners){
           l.bookAdd(ev);
        }
    }
    public void fireRemoveBookEvent(BookEvent ev){     // Fire remove event
        for(BookListener l : bookListeners){
           l.bookRemove(ev);
        }
    }
    public void fireUpdateBookEvent(BookEvent ev){    // Fire update event
        for(BookListener l : bookListeners){
           l.bookUpdate(ev);
        }
    }

    /*
     * SubjectEvent
     */
    public void addSubjectListener(SubjectListener l){        // Add a SubjectListener
        subjectListeners.add(l);
    }
    public void removeSubjectListener(SubjectListener l){     // Remove a SubjectListener
        subjectListeners.remove(l);
    }
    public void fireAddSubjectEvent(SubjectEvent ev){         // Fire add event
        for(SubjectListener l : subjectListeners){
           l.subjectAdd(ev);
        }
    }
    public void fireRemoveSubjectEvent(SubjectEvent ev){     // Fire remove event
        for(SubjectListener l : subjectListeners){
           l.subjectRemove(ev);
        }
    }
    public void fireUpdateSubjectEvent(SubjectEvent ev){    // Fire update event
        for(SubjectListener l : subjectListeners){
           l.subjectUpdate(ev);
        }
    }

    /* 
     * CategoryEvent
     */
    
    public void addCategoryListener(CategoryListener l){        // Add a CategoryListener
        categoryListeners.add(l);
    }
    public void removeCategoryListener(CategoryListener l){     // Remove a CategoryListener
        categoryListeners.remove(l);
    }
    public void fireAddCategoryEvent(CategoryEvent ev){         // Fire add event
        for(CategoryListener l : categoryListeners){
           l.categoryAdd(ev);
        }
    }
    public void fireRemoveCategoryEvent(CategoryEvent ev){     // Fire remove event
        for(CategoryListener l : categoryListeners){
           l.categoryRemove(ev);
        }
    }
    public void fireUpdateCategoryEvent(CategoryEvent ev){    // Fire update event
        for(CategoryListener l : categoryListeners){
           l.categoryUpdate(ev);
        }
    }

    /*
     * CustomerEvent
     */

    public void addCustomerListener(CustomerListener l){        // Add a CustomerListener
        customerListeners.add(l);
    }
    public void removeCustomerListener(CustomerListener l){     // Remove a CustomerListener
        customerListeners.remove(l);
    }
    public void fireAddCustomerEvent(CustomerEvent ev){         // Fire add event
        for(CustomerListener l : customerListeners){
           l.customerAdd(ev);
        }
    }
    public void fireRemoveCustomerEvent(CustomerEvent ev){     // Fire remove event
        for(CustomerListener l : customerListeners){
           l.customerRemove(ev);
        }
    }
    public void fireUpdateCustomerEvent(CustomerEvent ev){    // Fire update event
        for(CustomerListener l : customerListeners){
           l.customerUpdate(ev);
        }
    }

    /*
     * OrderEvent
     */

    public void addOrderListener(OrderListener l){        // Add an OrderListener
        orderListeners.add(l);
    }
    public void removeOrderListener(OrderListener l){     // Remove an OrderListener
        orderListeners.remove(l);
    }
    public void fireAddOrderEvent(OrderEvent ev){         // Fire add event
        for(OrderListener l : orderListeners){
           l.orderAdd(ev);
        }
    }
    public void fireRemoveOrderEvent(OrderEvent ev){     // Fire remove event
        for(OrderListener l : orderListeners){
           l.orderRemove(ev);
        }
    }
    public void fireUpdateOrderEvent(OrderEvent ev){    // Fire update event
        for(OrderListener l : orderListeners){
           l.orderUpdate(ev);
        }
    }

}
