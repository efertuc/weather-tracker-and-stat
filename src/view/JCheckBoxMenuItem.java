package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class JCheckBoxMenuItem extends JFrame {
    private JLabel statusBar;

    public JCheckBoxMenuItem() {
        initUI();
    }

    private void initUI() {
        createMenuBar();
        setTitle("Right menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        var viewMenu = new JMenu("View");
        var toolsMenu = new JMenu("Tools");
        var helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(toolsMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(() -> {
//
//            var ex = new JCheckBoxMenuItem();
//            ex.setVisible(true);
//        });
//    }

}
