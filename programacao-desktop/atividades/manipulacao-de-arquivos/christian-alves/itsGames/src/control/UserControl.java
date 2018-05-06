package control;

import model.User;

/**
 *
 * @author christian
 */
public class UserControl {
    
    public static boolean validate(String username, String pwd,
            String confirmedPwd, String email) throws Exception {
        String error = "";
        error += validateUserName(username);
        error += validatePassword(pwd);
        error += confirmPassword(pwd, confirmedPwd);
        error += validateEmail(email);
        
        if (!error.isEmpty())
            throw new Exception(error);
        
        return true;
    }
    
    private static String validateUserName(String userName) {
        String error = "";
        if (userName.equals(""))
            error += "The field \"Username\" cannot be empty.\n";
        if (userName.contains(" "))
            error += "The field \"Username\" must not contain espaces.";
        return error;
    }
    
    private static String validatePassword(String pwd) {
        String error = "";
        if (pwd.length() < 5)
            error += "Password must contain at least 5 characters.\n";
        return error;
    }
    
    private static String confirmPassword(String pwd, String confirmedPwd) {
        String error = "";
        if (!pwd.equals(confirmedPwd))
            error += "Passwords are different.\n";
        return error;
    }
    
    private static String validateEmail(String email) {
        String error = "";
        if (email.isEmpty()) {
            error += "Email cannot be empty.";
            return error;
        }
        
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        
        
        if (!m.matches())
            error += "Invalid email.\n";
        return error;
    }
    
}