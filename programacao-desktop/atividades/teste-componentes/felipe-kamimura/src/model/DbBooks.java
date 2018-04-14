/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author kamimuraf
 */
public class DbBooks {
    private DbBooks(){}
    
   private ArrayList<Book> books = new ArrayList<>();
   
   public void setBook(ArrayList<Book> books){
       this.books = books;
   }
   public ArrayList<Book> getBooks(){
       return books;
   }
   
   private static class DbBookHolder{
        private static final DbBooks INSTANCE = new DbBooks();
    }
   public static DbBooks getInstance(){
       return DbBookHolder.INSTANCE;}
}
