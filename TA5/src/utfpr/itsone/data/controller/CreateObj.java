package utfpr.itsone.data.controller;

import utfpr.itsone.data.UserData;
import utfpr.itsone.model.User;

/**
 *
 * @author Vinicius
 */
public class CreateObj {
    public CreateObj() {
        create();
    }
    
    public void create(){
            UserData.getData().addUser(new User("admin","admin@utfpr.com","21232F297A57A5A743894A0E4A801FC3"));
    }
}
