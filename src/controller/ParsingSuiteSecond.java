package controller;

import model.DataBaseTxt;
import model.DateWeather;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * класс парсинга со второго сайта
 */
public class ParsingSuiteSecond {
    public ParsingSuiteSecond() throws Exception {
        sai2();
    }

    static DateWeather info[] = new DateWeather[5];
    static String[] date = new String[5];

    /**
     * метод который определяет парсинг страницы
     * @throws Exception
     */
    public void sai2() throws Exception {
        try {
            String[] temp = new String[5];
            Parsing te = new Parsing();
            Document page = te.getPage("https://world-weather.ru/pogoda/russia/saint_petersburg/5days/");

            Elements tableWTH = page.select("div[id=content-left]");
            Elements names = tableWTH.select("td[class=td_short_gr]");
            Elements values = tableWTH.select("div[class=weather-short]");
            Elements temperature = values.select("tr[class=day]");
            date = te.getDate();

            int j = 0;
            for (Element i : temperature) {
                String tempString = i.select("td[class=weather-feeling]").text();
                tempString = te.getInfo(tempString);
                temp[j] = tempString;
                j++;
            }

            DataBaseTxt db = new DataBaseTxt("./Test2.txt");
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



//        System.out.println(temperature);
//        System.out.println(Arrays.toString(date));
//        System.out.println(date);
//        System.out.println(db.read4File(4));

    }
}

//    public static void main(String[] args) throws Exception {
//        sai2();
//    }

