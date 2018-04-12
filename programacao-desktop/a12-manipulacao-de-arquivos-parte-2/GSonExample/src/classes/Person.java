package classes;

import java.util.ArrayList;
import java.util.List;

public class Person {
    
    private String firstName;
    private String lastName;
    private int age;
    private List phones = new ArrayList();

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the phones
     */
    public List getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(List phones) {
        this.phones = phones;
    }
}
