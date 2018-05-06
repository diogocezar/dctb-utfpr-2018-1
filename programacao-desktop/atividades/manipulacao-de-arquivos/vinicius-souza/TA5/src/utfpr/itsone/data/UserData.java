/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.itsone.data;

import java.util.ArrayList;
import java.util.List;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class UserData {
     private ArrayList<User> users = new ArrayList<>();

    public static UserData getData(){
        return Data.INSTANCE;
    }
    
     private static class Data {
        private static final UserData INSTANCE = new UserData();
    }
            
    public void addUser(User user){
        users.add(user);
    }
    
      public void addUser(List<User> users){
        this.users.addAll(users);
    }
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public User search(long id){
        for(User userName : UserData.getData().getUsers()){
            if(userName.getId() == id){
                return userName;
            }
        }
        return null;
    }
}
