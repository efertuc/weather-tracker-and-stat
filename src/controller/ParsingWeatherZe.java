package controller;

import model.DataBaseTxt;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;

/**
 * класс для получения текущей инфы по погоде в Зеленограде
 */
public class ParsingWeatherZe extends Parsing {
    /**
     * метод получения информации по погоде в Зеленограде
     * @param debug
     * @return возвращает температуру
     * @throws Exception
     */
    public String getDates(boolean debug) throws Exception {
        String temp="Сейчас в Зеленограде : ";
        try {
//            Parsing te = new Parsing();
            Document page = getPage("https://world-weather.ru/pogoda/russia/zelenograd/");
            Elements tableWTH = page.select("div[id=content-left]");
            tableWTH =tableWTH.select("div[id=weather-now-number]");
            temp+=tableWTH.text();
            if(debug){ DataBaseTxt.Log_File("INFO", "Получены данные о текущей погоде ");}
            return temp;
        }catch (Exception exception){
            if(debug){ DataBaseTxt.Log_File("WARN", "Не удалось установить соединение с сайтом");}
            JOptionPane.showMessageDialog(null,"Не удалось установить соединение с сайтом ","ERROR",JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();

        }
        finally {
            return temp;
        }



//        System.out.println(tableWTH.text());

//        temp = te.printValues(names);
//        int j = 0;
//        for (Element name : names) {
//            String dateString = name.select("th[id=dt]").text();
//        }
//        date = te.getDate();
//        DataBaseTxt db = new DataBaseTxt("./Test.txt");
//        for (int i = 0; i < 5; i++) {
//            info[i] = new DateWeather();
//            info[i].setDate(date[i]);
//            info[i].setTemp(temp[i]);
//            info[i].setDateNow(date[0]);
//            db.write2File(info[i].toString());
//        }

    }
}
