package utfpr.desktop.components.gui;

import javax.swing.*;

public class Wrapper {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Container();
            }
        });
    }
}
