package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для подключения к саайтам
 */
public class Parsing {
    /**
     * метод получает html код страницы по ее ссылке
     * @param str - адрес
     * @return возвращаем код страници
     * @throws IOException
     */
    public static Document getPage(String str) throws IOException {
        String url = str;
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");
    private static Pattern patternTime = Pattern.compile("\\D?\\d{1,2}");

    /**
     * ничего не делает, в будущем модет пригодится
     * @param stringDate
     * @return
     * @throws Exception
     */
    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract date from Strindg");
    }

    /**
     * достаем из html температуру
     * @param stringInfo html страници
     * @return возвращаем температуру
     * @throws Exception
     */
    public static String getInfo(String stringInfo) throws Exception {
        Matcher matcher = patternTime.matcher(stringInfo);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract date from Strindg");
    }

    /**
     * метод для выборки данных из потока данных
     * @param values html страници
     * @return
     * @throws Exception
     */
    public static String[] printValues(Elements values) throws Exception {
        int index = values.size();
        String[] res = new String[5];
        int temp = (index % 4) + 1;
        if ((index % 4) == 3) temp = 0;
        for (int i = 0; i < index; i++) {
            Element valueLine = values.get(temp);
            String sr = valueLine.select("td[width=80]").text();
            String temperatur = getInfo(sr);
//            System.out.println(temperatur);
            res[i] = temperatur;

            temp += 4;
            if (temp > index) {
                System.out.println(Arrays.toString(res));
//                System.out.println(res);
                return res;
            }
        }
        return res;
    }

    /**
     * метод для получения массива дат, начиная с текущей +4
     * @return массив дат +4 с текущей
     * @throws ParseException
     */
    public static String[] getDate() throws ParseException {
        String[] date = new String[5];
        Date dateNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
        String dt = sdf.format(dateNow);
        date[0] = dt;// Start date

        for (int i = 1; i < 5; i++) {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date[i - 1]));
            c.add(Calendar.DATE, 1);  // number of days to add
            date[i] = sdf.format(c.getTime());
//            System.out.println(date[i]);

        }
        return date;
    }

}