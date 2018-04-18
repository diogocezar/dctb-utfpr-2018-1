package databaseexample1;

public class DataBaseExample1 {
    public static void main(String[] args) {
        try {
            // Exemplo 1
            //new SelectFromDatabase().readDatabase();
            
            // Exemplo 2
            //new InsertIntoDatabase().saveDatabase();
            
            // Exemplo 3
            //new UpdateFromDatabase().updateDatabase();
            
            // Exemplo 4
            //new DeleteFromDatabase().deleteDatabase();
        } catch (Exception ex) {
            System.out.println("Houve um erro: " + ex.getMessage());
        }
    }
}
