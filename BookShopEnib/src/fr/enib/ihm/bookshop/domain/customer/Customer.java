/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.customer;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Serge Morvan
 */
public class Customer implements Serializable{

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private Date dateOfBirth;
    private CreditCard creditCard;
    private Address address;
    static private final long serialVersionUID = 33L;
    
    public Customer() {
    }

    public Customer(String login, String firstName, String lastName, String telephone, String email, Address address) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     *
     * @return string
     */
    @Override
    public String toString(){
        return new String(firstName + " " + lastName);
    }

}
