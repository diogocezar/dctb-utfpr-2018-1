/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TableView;

/**
 *
 * @author gabriel
 */
public class Validate {

    private static StringBuilder errorMessage = new StringBuilder();
    
    private static final int NAME_MAX_LENGTH = 50;
    private static final int NICK_MIN_LENGTH = 4;
    private static final int NICK_MAX_LENGTH = 25;
    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int PASSWORD_MAX_LENGTH = 15;

    private static final String TEL_NUMBER_PATTERN = "0?[0-9]{2}[0-9]?[0-9]{4}[0-9]{4}";
    private static final String NICKNAME_PATTERN = "[a-z][a-z0-9]*";
    private static final String ADDRESS_NUMBER_PATTERN = "[0-9]*(.)?[0-9]*";
    private static final String CPF_PATTERN = "[0-9]{3}(.)[0-9]{3}(.)[0-9]{3}(-)[0-9]{2}";
    private static final String RG_PATTERN = "[0-9]{2}(.)[0-9]{3}(.)[0-9]{3}(-)[0-9]{1}";
    private static final String CNPJ_PATTERN = "[0-9]{2}(.)[0-9]{3}(.)[0-9]{3}||[0-9]{4}(-)[0-9]{2}";
    
    public static String getErrorMessage() {
        String msg = errorMessage.toString();
        errorMessage = new StringBuilder();
        return(msg);
    }
    
    
    public static boolean validateEmpty(String fieldName, String content) {
        if(content.isEmpty()) {
            errorMessage.append(fieldName).append(" não pode ser vazio!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
    public static boolean validateTelephone(String num) {
        String pattern = TEL_NUMBER_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(num);
        
        if(!matcher.matches()) {
            errorMessage.append("Formato de telefone inválido!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
//    public static boolean validaNum(String num) {
//        String pattern = TEL_NUMBER_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(num);
//        if (num.isEmpty()) {
//            return (false);
//        } else if (!matcher.matches()) {
//            return (false);
//        } else {
//            return (true);
//        }
//    }

    
    public static boolean validateName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            errorMessage.append("Nome muito grande!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
//    public static boolean validaNome(String nome) {
//        if (nome.isEmpty()) {
//            return (false);
//        } else if (nome.length() > NAME_MAX_LENGTH) {
//            return (false);
//        } else {
//            return (true);
//        }
//    }

    public static boolean validateNick(String nick) {
        String pattern = NICKNAME_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(nick);
        
        if(!matcher.matches()) {
            errorMessage.append("Formato de nickname inválido!\n");
            return(false);
        } else if(nick.length() < NICK_MIN_LENGTH) {
            errorMessage.append("Nickname muito curto!\n");
            return(false);
        } else if(nick.length() > NICK_MAX_LENGTH) {
            errorMessage.append("Nickname muito longo!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
//    public static boolean validaNick(String nick) {
//        String pattern = NICKNAME_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(nick);
//        if (nick.isEmpty()) {
//            return (false);
//        } else if (!matcher.matches()) {
//            return (false);
//        } else if (nick.length() < NICK_MIN_LENGTH) {
//            return (false);
//        } else if (nick.length() > NICK_MAX_LENGTH) {
//            return (false);
//        } else {
//            return (true);
//        }
//    }

    public static boolean validatePassword(String password) {
        if (password.length() > PASSWORD_MAX_LENGTH) {
            errorMessage.append("Senha muito longa!\n");
            return(false);
        } else if(password.length() < PASSWORD_MIN_LENGTH) {
            errorMessage.append("Senha muito curta!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
//    public static boolean validaPassword(String password) {
//        if (password.isEmpty()) {
//            return false;
//        }
//        if (password.length() > PASSWORD_MAX_LENGTH) {
//            return false;
//        }
//        return password.length() > PASSWORD_MIN_LENGTH;
//    }

    public static boolean validateAddressNumber(String num) {
        String pattern = ADDRESS_NUMBER_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(num);
        
        if(!matcher.matches()) {
            errorMessage.append("Não é um número!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
    
//    public static boolean validaNumAddress(String num) {
//        String pattern = ADDRESS_NUMBER_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(num);
//        if (num.isEmpty()) {
//            return false;
//        }
//        return matcher.matches();
//    }

    public static boolean validateCPF(String cpf) {
        String pattern = CPF_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(cpf);
        
        if(!matcher.matches()) {
            errorMessage.append("Número de CPF inválido!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
    public static boolean validateCNPJ(String cnpj) {
        String pattern = CNPJ_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(cnpj);
        
        if(!matcher.matches()) {
            errorMessage.append("Número de CNPJ inválido!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
    public static boolean validateRG(String rg) {
        String pattern = RG_PATTERN;
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(rg);
        
        if(!matcher.matches()) {
            errorMessage.append("Número de RG inválido!\n");
            return(false);
        } else {
            return(true);
        }
    }
    
//    public static boolean validaCPF(String cpf) {
//        String pattern = CPF_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(cpf);
//        return matcher.matches();
//    }
//
//    public static boolean validaCNPJ(String cnpj) {
//        String pattern = CNPJ_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(cnpj);
//        return matcher.matches();
//    }
//    
//    public static boolean validaRG(String rg) {
//        String pattern = RG_PATTERN;
//        Pattern test = Pattern.compile(pattern);
//        Matcher matcher = test.matcher(rg);
//        return matcher.matches();
//    }
    
    public static boolean passwordMatch(String pass1, String pass2){
        if(pass1.equals(pass2)){
            return true;
        }else{
            errorMessage.append("Senhas diferentes!\n");
            return false;
        }
    }
    
    public static boolean emptyTable(TableView table){
        if(table.getItems().isEmpty()){
            errorMessage.append("Nenhum item adicionado!\n");
            return false;
        }else{
            return true;
        }
    }
}
