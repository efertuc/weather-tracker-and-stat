package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GraphWin {
    public void InputShw() {

        JFrame Login = new JFrame("Список элементов: ");
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.setSize(800, 400);
        JLabel inpLog = new JLabel();

        JTextArea size = new JTextArea();
        inpLog.setText("Список:");

        JPanel panel = new JPanel();

        JButton Enter = new JButton("Ок");
        Enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.dispose();
                MenuWin qwe = new MenuWin();
                try {
                    qwe.menuWin(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });


//        String outPut = "";
//        String pruf = "D";
//        try {
//            Path path = Paths.get("C:\\Users\\Victory\\Desktop\\Java2\\Java\\laba6\\temp.txt");
//            Scanner scan = new Scanner(path);
//            while (scan.hasNextLine()) {
//                String line = scan.nextLine();
//                if (line.charAt(0) != pruf.charAt(0)) {
//                    outPut = outPut + line + "\n";
//                }
//            }
//            scan.close();
//            DataBase.Log_File("INFO", "Метод Show чтение информации из файла temp.txt");
//        } catch (IOException ex) {
//            DataBase.Log_File("WARN", "Метод ShowInfo IOException ex");
//
//        }

//        size.setText(outPut);

        inpLog.setBounds(1, 1, 200, 20);
        size.setBounds(1, 20, 200, 225);
        Enter.setBounds(225, 210, 70, 30);
        panel.setLayout(null);

        panel.add(inpLog);
        panel.add(size);
        panel.add(Enter);

        Login.add(panel);

        panel.setVisible(true);
        Login.setVisible(true);

    }

}
