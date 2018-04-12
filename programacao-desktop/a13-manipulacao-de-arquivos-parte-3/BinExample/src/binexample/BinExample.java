package binexample;

public class BinExample {

    public static void main(String[] args) {
        CreateSequentialFile app = new CreateSequentialFile();
        ReadSequentialFile application = new ReadSequentialFile();
        
        app.openFile();
        app.addRecords();
        app.closeFile();
        
        application.openFile();
        application.readRecords();
        application.closeFile();
        
    }
}
