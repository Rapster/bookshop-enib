/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.enib.ihm.bookshop.domain.customer;

import java.io.Serializable;

/**
 *
 * @author Serge Morvan
 */
public class Address implements Serializable {

    private int streetNumber;
    private String street;
    private String city;
    private String zipcode;
    private String country;
    static private final long serialVersionUID = 33L;
    
    public Address() {
    }

    public Address(int streetNumber, String street, String city, String zipcode, String country) {
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
        @Override
    public boolean equals(Object obj) {
        // Vérification de l'égalité des références
        // Vérification du type du paramètre
        if (obj instanceof Address) {
            // Vérification des valeurs des attributs
            Address other = (Address) obj;
            if(this.streetNumber != other.streetNumber){
                return false;
            }
            if (this.street != other.street) {
                if (this.street == null || !this.street.equals(other.street)) {
                    return false; // les attributs sont différents
                }
            }
            if (this.city != other.city) {
                if (this.city == null || !this.city.equals(other.city)) {
                    return false; // les attributs sont différents
                }
            }
            if (this.zipcode != other.zipcode) {
                if (this.zipcode == null || !this.zipcode.equals(other.zipcode)) {
                    return false; // les attributs sont différents
                }
            }
            if (this.country != other.country) {
                if (this.country == null || !this.country.equals(other.country)) {
                    return false; // les attributs sont différents
                }
            }
            return true;
        }

        return false;
    }

}
