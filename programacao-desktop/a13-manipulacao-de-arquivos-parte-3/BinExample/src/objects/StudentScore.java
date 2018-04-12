
package objects;

import java.io.Serializable;

public class StudentScore implements Serializable{
    
    private String firstName;
    private String lastName;
    private int score;
    
    public StudentScore(String firstName, String lastName, int score){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setScore(score);
    }

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
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
    