package game.gui;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Console extends JPanel {
    JTextArea aTextArea = new JTextArea(5,30);
    PrintStream aPrintStream = new PrintStream(new FilteredStream(new ByteArrayOutputStream()));
    FileWriter aWriter;
    String nameFile;

    public Console() {
        add("Center", new JScrollPane(aTextArea));
        setVisible(true);
        setOpaque(false);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
        Date date = new Date();
        nameFile = dateFormat.format(date);
        System.setOut(aPrintStream);
        System.setErr(aPrintStream);
    }

    class FilteredStream extends FilterOutputStream {
        public FilteredStream(OutputStream aStream) {
            super(aStream);
        }

        public void write(byte b[]) throws IOException {
            String aString = new String(b);
            aTextArea.append(aString);
        }

        public void write(byte b[], int off, int len) throws IOException {
            String aString = new String(b, off, len);
            aWriter = new FileWriter("logs\\"+nameFile+".log",true);
            aTextArea.append(aString);
            aWriter.write(aString);
            aWriter.close();
        }
    }
}