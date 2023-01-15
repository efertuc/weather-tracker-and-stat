package controller;

import model.DateWeather;
import model.DataBaseTxt;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * класс для получения информации с первого сайта
 */
public class ParsingSuiteFirst extends Parsing {
    /**
     * конструктор
     * @throws Exception
     */
    public ParsingSuiteFirst() throws Exception {
        sait1();
    }

    static DateWeather info[] = new DateWeather[5];
    static String[] date = new String[5];

    /**
     * парсинг инфы со страници
     */
    public void sait1() {
        try {
            String[] temp;
//            test te = new test();
            Document page = getPage("https://www.pogoda.spb.ru/");
            Element tableWTH = page.select("table[class=wt]").first();
            Elements names = tableWTH.select("tr[class=wth]");
            Elements values = tableWTH.select("tr[valign=top]");

            temp = printValues(values);
            int j = 0;
            for (Element name : names) {
                String dateString = name.select("th[id=dt]").text();
            }
            date = getDate();
            DataBaseTxt db = new DataBaseTxt("./Test.txt");
            for (int i = 0; i < 5; i++) {
                info[i] = new DateWeather();
                info[i].setDate(date[i]);
                info[i].setTemp(temp[i]);
                info[i].setDateNow(date[0]);
                db.write2File(info[i].toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Не удалось установить соединение с сайтом ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}


