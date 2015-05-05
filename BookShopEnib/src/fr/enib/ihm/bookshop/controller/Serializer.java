/*
 * Serializer
 * Permet de serialiser (en binaire) toutes les données de l'application
 * 
 */

package fr.enib.ihm.bookshop.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author yoann
 */
public class Serializer {
    private static Serializer instance = null;
    /* Constructors */
    private Serializer(){        
    }
     /**
      * Return instance of Serializer
      */
    public synchronized static Serializer getInstance(){
         if(instance == null) {
            instance = new Serializer();
        }
        return instance;
    }  

    /**
     * Permet de sérialiser les données vers le dossier ressource
     *
     */
    public void serialise(){
       try {
                // --  Categories
                Categories categories = Categories.getInstance();
                FileOutputStream fosCategories = new FileOutputStream("src/ressources/serial/Categories.serial");
                ObjectOutputStream oosCategories = new ObjectOutputStream(fosCategories);
                // -- Subjects
                Subjects subjects = Subjects.getInstance();
                FileOutputStream fosSubjects = new FileOutputStream("src/ressources/serial/Subject.serial");
                ObjectOutputStream oosSubjects = new ObjectOutputStream(fosSubjects);
                // -- Books
                Books books = Books.getInstance();
                FileOutputStream fosBooks = new FileOutputStream("src/ressources/serial/Books.serial");
                ObjectOutputStream oosBooks = new ObjectOutputStream(fosBooks);
                // -- Customers
                Customers customers = Customers.getCustomers();
                FileOutputStream fosCustomers = new FileOutputStream("src/ressources/serial/Customers.serial");
                ObjectOutputStream oosCustomers = new ObjectOutputStream(fosCustomers);
                // -- Orders
                Orders orders = Orders.getInstance();
                FileOutputStream fosOrders = new FileOutputStream("src/ressources/serial/Orders.serial");
                ObjectOutputStream oosOrders = new ObjectOutputStream(fosOrders);
                try {
                        // -- Categories
                        oosCategories.writeObject(categories);
                        oosCategories.flush();
                        // -- Subjects
                        oosSubjects.writeObject(subjects);
                        oosSubjects.flush();
                        // -- Books
                        oosBooks.writeObject(books);
                        oosBooks.flush();
                        // -- Customers
                        oosCustomers.writeObject(customers);
                        oosCustomers.flush();
                        // -- Orders
                        oosOrders.writeObject(orders);
                        oosOrders.flush();
                } finally {
                        try {
                                oosCategories.close();
                                oosSubjects.close();
                                oosBooks.close();
                                oosCustomers.close();
                                oosOrders.close();
                        } finally {
                                fosCategories.close();
                                fosSubjects.close();
                                fosBooks.close();
                                fosCustomers.close();
                                fosOrders.close();
                        }
                }
            } catch(IOException ioe) {
                    ioe.printStackTrace();
            }
    }
    /**
     * Permet de désérialiser les données à partir des données du dossier ressource
     * 
     */
    public void deserialise(){
       try {
           // -- Categories
            FileInputStream fisCategories = new FileInputStream("src/ressources/serial/Categories.serial");
            ObjectInputStream oisCategories = new ObjectInputStream(fisCategories);
            // -- Subjects
            FileInputStream fisSubjects = new FileInputStream("src/ressources/serial/Subject.serial");
            ObjectInputStream oisSubjects = new ObjectInputStream(fisSubjects);
            // -- Books
            FileInputStream fisBooks = new FileInputStream("src/ressources/serial/Books.serial");
            ObjectInputStream oisBooks = new ObjectInputStream(fisBooks);
            // -- Customers
            FileInputStream fisCustomers = new FileInputStream("src/ressources/serial/Customers.serial");
            ObjectInputStream oisCustomers = new ObjectInputStream(fisCustomers);
            // -- Orders
            FileInputStream fisOrders = new FileInputStream("src/ressources/serial/Orders.serial");
            ObjectInputStream oisOrders = new ObjectInputStream(fisOrders);
            try {
                  oisCategories.readObject();
                  oisSubjects.readObject();
                  oisBooks.readObject();
                  oisCustomers.readObject();
                  oisOrders.readObject();
            } finally {
                    // -- Categories
                    oisCategories.close();
                    fisCategories.close();
                    // -- Subjects
                    oisSubjects.close();
                    fisSubjects.close();
                    // -- Books
                    oisBooks.close();
                    fisBooks.close();
                    // -- Customers
                    oisCustomers.close();
                    fisCustomers.close();
                    // --  Orders
                    oisOrders.close();
                    fisOrders.close();
            }
        } catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
        } catch(IOException ioe) {
                ioe.printStackTrace();
        }
    }
}
