package view;

import model.DataBaseTxt;
import model.ReadProperties;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * класс отвечающий за авторизацию пользователей в приложении
 */
public class StartWin {
    /**
     * метод прослойка между авторизацией и главной страницей
     * @param check параметр для дебага
     * @param Login Jframe
     */
    public static void Check(boolean check,JFrame Login){
        File file = new File("LoginOf.txt");
        FileWriter DataFile;
        try {
            file.createNewFile();
            DataFile = new FileWriter(file, false);
            DataFile.close();
            Login.dispose();
            //Открыть Меню
            MenuWin qwe = new MenuWin();
            qwe.menuWin(check);
            if(check){

                DataBaseTxt.Log_File("INFO", "Выполнен вход администратором");
                DataBaseTxt.Log_File("INFO", "Метод LOGIN");
            }
//            else  DataFile.write("2");
        } catch (IOException var12) {
            DataBaseTxt.Log_File("WARN", "Метод Check");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * метод создания страниц и проверки на подлиность пользовтеля
     */
    public static void LoginWin() {
        JFrame Login = new JFrame("Вход: ");
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.setSize(350,230);

        JTextField log = new JTextField(8);
        JPasswordField pass = new JPasswordField(8);
        pass.setEchoChar('*');

        JLabel icon = new JLabel("c==|=========>");
        JLabel inpLog = new JLabel("Введите логин:");
        JLabel inpPass = new JLabel("Введите пароль:");
        JPanel panel = new JPanel();
        JButton Enter = new JButton("Войти");


        Enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReadProperties properties=new ReadProperties();
                String[] info = new String[0];
                try {
                    info = properties.Example1();
                } catch (IOException ioException) {
                    DataBaseTxt.Log_File("WARN", "Properties");
                    ioException.printStackTrace();
                }
                String line;
                String pruf1 = log.getText();
                line = new String(pass.getPassword());

                System.out.println(pruf1+" "+line);
                boolean zapis;
                File file;
                FileWriter DataFile;

                //debug
                if (pruf1.equals(info[0]) & line.equals(info[1])) {
                    System.out.println(Boolean.parseBoolean(info[2]));
                    Check(Boolean.parseBoolean(info[2]),Login);
                    //release
                }else if (pruf1.equals(info[3]) & line.equals(info[4])) {
                    System.out.println(Boolean.parseBoolean(info[5]));
                    Check(Boolean.parseBoolean(info[5]),Login);
                }else {
                    zapis = false;
                    file = new File("LoginOf.txt");
                    try {
                        file.createNewFile();
                        DataFile = new FileWriter(file, false);
                        DataFile.write("0");
                        DataFile.close();
                        System.out.println("Неверный логин или пароль...");
                        JOptionPane.showMessageDialog(null,"Неверный логин или пароль...","ERROR",JOptionPane.ERROR_MESSAGE);
                        Login.dispose();
                        LoginWin();
//
//                        System.exit(1);
                    } catch (IOException var11) {
                        DataBaseTxt.Log_File("WARN", "Метод LOGIN IOException ex");
                    }
                }
            }

        });


        icon.setBounds(90, 5, 100, 20);
        inpLog.setBounds(90, 30, 100, 20);
        log.setBounds(90, 50, 150, 20);
        inpPass.setBounds(90, 70, 150, 20);
        pass.setBounds(90, 90, 150, 20);
        Enter.setBounds(128, 115, 70, 30);
        panel.setLayout(null);

        panel.add(inpLog);
        //panel.add(icon);
        panel.add(log);
        panel.add(inpPass);
        panel.add(pass);
        panel.add(Enter);

        Login.add(panel);

        panel.setVisible(true);
        Login.setVisible(true);

    }
}