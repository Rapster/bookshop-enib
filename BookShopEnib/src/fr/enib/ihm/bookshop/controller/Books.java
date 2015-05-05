package fr.enib.ihm.bookshop.controller;

import fr.enib.ihm.bookshop.controller.events.BookEvent;
import fr.enib.ihm.bookshop.controller.listeners.BookListener;
import fr.enib.ihm.bookshop.domain.catalog.Book;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yo8chapa
 */
public class Books extends AbstractTableModel implements BookListener, Serializable  {
    static private final long serialVersionUID = 33L;
    private ArrayList<Book> books = null;
    private String[] columnNames = {"Id", "Title", "Author", "Editor"};
    private static Books instance = null;
    
    /* Constructors */
    private Books(){
        this(new ArrayList<Book>());
    }
    private Books(ArrayList<Book> books){
        this.books = books;
        ApplicationEventsDispatcher.getApplicationEventsDispatcher().addBookListener(this);
    }
    
    /* Return instance of Categories */
    public synchronized static Books getInstance(){
        if(instance == null) {
            instance = new Books();
        }
        return instance;
    }
    /* Uses' method List */
    public void addBook(Book b){
        b.setId(getId());
        books.add(b);
        this.fireTableDataChanged();
    }
    public void removeBook(Book book){
        //Book book = this.getBookById(idSpecifie);
        books.remove(book);
        this.fireTableDataChanged();
    }
    public void updateBook(Book b){
       Book bookToUpdate = getBookById(b.getId());
       if(bookToUpdate != null){
        bookToUpdate.setIsbn(b.getIsbn());
        bookToUpdate.setTitle(b.getTitle());
        bookToUpdate.setAuthor(b.getAuthor());
        bookToUpdate.setDateOfParution(b.getDateOfParution());
        bookToUpdate.setEditor(b.getEditor());
        bookToUpdate.setImagePath(b.getImagePath());
        bookToUpdate.setLang(b.getLang());
        bookToUpdate.setPrice(b.getPrice());
       }
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public void setBooksList(ArrayList<Book> books){
        this.books = books;
    }
    /* Implements CategoryListener */
    public void bookAdd(BookEvent ev){
        addBook(ev.getBook());
    }
    public void bookRemove(BookEvent ev){
        removeBook(ev.getBook());
    }
    public void bookUpdate(BookEvent ev){
        updateBook(ev.getBook());
    }
    /**
     *
     * @return id incremente
     */

    public int getId(){
        if(this.books.size() > 0){
            return this.books.get(books.size()-1).getId() + 1;
        }
        else
            return 1;
    }
    public Book getBookById(int id){
        for(Book book : this.books){
            if(book.getId() == id){
                return book;
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
        return this.books.size();
    }

    /**
      * Méthode abstraite dans AbstractTableModel : nombre de colonnes de la table
      */
    public int getColumnCount() {
        return 4;
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
        Book book = this.books.get(rowIndex);
        Object o = null;

        switch (columnIndex) {
            case 0:
                o = book.getId();
                break;
            case 1:
                o = book.getTitle();
                break;
            case 2:
                o = book.getAuthor();
                break;
            case 3:
                o = book.getEditor();
                break;
        }
        return o;
    }
    /**
     * Méthode de récupération d'un book à une ligne spécifiée dans la JTable
     * @param rowIndex
     * @return
     */
    public Book getBookAtRow(int rowIndex){
        return books.get(rowIndex);
    }

    /**
     * Méthode appelé implicitement par l'objet ObjectInputStream lors de la désérialisation
     * Celle-ci permet d'assurer l'unicité du singleton, et non de retourner une nouvelle référence comme le fait le mécanisme de la désérialisation
     * @return instance static
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
	// récupération des données désérialisées
	ArrayList<Book> bookList = getBooks();
	// récuperation de l'instance static
	Books booksInstance = getInstance();
	// affectation des données désérialisées à l'instance static.
	booksInstance.setBooksList(bookList);
	// retourne l'instance static
	return booksInstance;
    }
}
