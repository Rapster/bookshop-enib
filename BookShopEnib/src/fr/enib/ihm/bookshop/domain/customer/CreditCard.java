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
public class CreditCard implements Serializable{

    private String creditCardNumber;
    private String creditCardType;
    private String creditCardExpDate;
    static private final long serialVersionUID = 33L;
    
    public CreditCard() {
    }

    public CreditCard(String creditCardNumber, String creditCardType, String creditCardExpDate) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardType = creditCardType;
        this.creditCardExpDate = creditCardExpDate;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public void setCreditCardExpDate(String creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
    }

    @Override
    public boolean equals(Object obj) {
        // Vérification de l'égalité des références
        if (obj==this) {
            return true;
        }
        // Vérification du type du paramètre
        if (obj instanceof CreditCard) {
            // Vérification des valeurs des attributs
            CreditCard other = (CreditCard) obj;
            if (this.creditCardNumber != other.creditCardNumber) {
                if (this.creditCardNumber == null || !this.creditCardNumber.equals(other.creditCardNumber)) {
                    return false; 
                }
            }
            if (this.creditCardType != other.creditCardType) {
                if (this.creditCardType == null || !this.creditCardType.equals(other.creditCardType)) {
                    return false; 
                }
            }
            if (this.creditCardExpDate != other.creditCardExpDate) {
                if (this.creditCardExpDate == null || !this.creditCardExpDate.equals(other.creditCardExpDate)) {
                    return false; 
                }
            }
            return true;// les attributs sont identiques
        }

        return false; // les attributs sont différents
    }
}
