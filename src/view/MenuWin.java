package view;

import controller.ParsingWeatherZe;
import model.Calculate;
import model.DataBaseTxt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * класс для представления основной информации программ
 * главная страница проги
 */
public class MenuWin {
    static JMenuBar mb;
    static JMenu fileMenu,helpMenu;
    static JMenuItem m1;
    static String help="Разработчик : \n Кононова Виктория \n гр. ПИН-31";

    /**
     * интерфейс главной страницы программы
     * @param debug параметр логирования
     * @throws Exception
     */
    public static void menuWin(boolean debug) throws Exception {
        JFrame Login = new JFrame("Меню: ");
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.setSize(500,350);
        ParsingWeatherZe PZ=new ParsingWeatherZe();
        String pogoda = PZ.getDates(debug);
        String sait = "Самый точный прогноз у сайта ";

        Calculate ca =new Calculate();
        DataBaseTxt DB = new DataBaseTxt("./Test.txt");
        DataBaseTxt DB2 = new DataBaseTxt("./Test2.txt");
        if(ca.getBestSuite(DB)<ca.getBestSuite(DB2)) sait+="www.pogoda.spb.ru";
        else sait+="world-weather.ru";


        JLabel menu = new JLabel("  Погода  ");
        JLabel menu1 = new JLabel(pogoda);
        JLabel menu5 = new JLabel(sait);
        JLabel menu2 = new JLabel(" Выберите действие :");
        JLabel menu3 = new JLabel("1. Построитьь график для 1-го сайта -> ");
        JLabel menu4 = new JLabel("2. Построитьь график для 2-го сайта  -> ");


//        MenuForAdd AddEl = new MenuForAdd();
//        InputWin New1 = new InputWin();

        JPanel panel = new JPanel();

        JButton Add = new JButton("www.pogoda.spb.ru");
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(debug){ DataBaseTxt.Log_File("INFO", "Строим график для сайта www.pogoda.spb.ru");}
                Graph Dg = new Graph();
                Dg.DrawGraphs(1,debug);
                Login.dispose();

            }
        });

        JButton Del = new JButton("world-weather.ru");
        Del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(debug){ DataBaseTxt.Log_File("INFO", "Строим график для сайта world-weather.ru");}
                Graph Dg = new Graph();
                Dg.DrawGraphs(2,debug);
                Login.dispose();
            }
        });

//
//        JButton fileMenu = new JButton("file");
//
//        JButton helpMenu = new JButton("help");


        mb = new JMenuBar();

        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        m1 = new JMenuItem(help);

        helpMenu.add(m1);
        mb.add(fileMenu);
        mb.add(helpMenu);


        menu.setBounds(100, 20, 150, 20);
        menu1.setBounds(20, 60, 250, 20);
        menu5.setBounds(20, 100, 300, 20);
        menu2.setBounds(20, 140, 250, 20);
        menu3.setBounds(20, 180, 250, 20);
        menu4.setBounds(20, 220, 250, 20);

        Add.setBounds(300, 170, 150, 30);
        Del.setBounds(300, 210, 150, 30);

        panel.setLayout(null);
        panel.add(menu);
        panel.add(menu1);
        panel.add(menu5);
        panel.add(menu2);
        panel.add(menu3);
        panel.add(menu4);
        Login.setJMenuBar(mb);
        panel.add(Add);
        panel.add(Del);
        Login.add(panel);
        panel.setVisible(true);
        Login.setVisible(true);
    }
}
