package model;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для подсчета точности температуры
 */
public class Calculate {

    private static Pattern patternTemp = Pattern.compile("\\D?\\d{1,2}");

    /**
     * метод получения температуры из базы данных
     * @param stringDate
     * @return температуру из бд
     * @throws Exception
     */
    public static int getTempFromString(String stringDate) throws Exception {
        Matcher matcher = patternTemp.matcher(stringDate);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new Exception("Cant extract date from Strindg");
    }

    /**
     * метод получения массива температур
     * @param DB массив темеператур и сопутствующей инфы в файлике
     * @return массив температур
     */
    private int[] getTemp(DataBaseTxt DB) {

        String[] date = new String[40];
        int[] temp = new int[40];
        int res;
        try {
            for (int i = 0; i < temp.length-1; i++) {
                date[i] = String.valueOf(DB.read4File(i));
                String[] rtt = new String[3];
                rtt = date[i].split(" ");
                res = getTempFromString(rtt[1]);
                System.out.println(res+"   "+i);
                temp[i] = res;
            }
            System.out.println(Arrays.toString(temp));
//            return temp;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            return temp;
        }

//        System.out.println(Arrays.toString(date));
//        System.out.println(Arrays.toString(temp));

    }

    /**
     * метод получения коэфициентов для определения точности прогнозов погоды
     * @param DB массив темеператур и сопутствующей инфы в файлике
     * @return массиф коэфициентов точности температуры
     */
    public Double[] getKoef(DataBaseTxt DB) {
        int[] temperatur = getTemp(DB);
        System.out.println(Arrays.toString(temperatur));
        Double[] koef = new Double[5];
        try {
            koef[0]=0.0;
            for (int i = 0; i < 4; i++) {
                switch (i) {
                    case 0:
                        koef[1] = getPrevius(temperatur);
                        break;
                    case 1:
                        koef[2] = get2days(temperatur);
                        break;
                    case 2:
                        koef[3] = get3days(temperatur);
                        break;
                    case 3:
                        koef[4] = get4days(temperatur);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return koef;
        }
    }

    /**
     * метод получения коэфициентов разницы вчерашнего и сегодняшнего дня
     * @param temperatur массив температур
     * @return коэфициент
     * @throws Exception
     */
    private double getPrevius(int[] temperatur) throws Exception {
        System.out.println(Arrays.toString(temperatur));
        int i = 1;
        double koef1 = 0;
        do {
            koef1 += Math.abs(temperatur[i] - temperatur[i + 4]);
            i += 5;
//            System.out.println("1  "+koef1);
        } while (i <= 31);
        return koef1 / 7;
    }

    /**
     * метод получения коэфициентов разницы позавчерашнего и сегодняшнего дня
     * @param temperatur массив температур
     * @return коэфициент
     * @throws Exception
     */
    private double get2days(int[] temperatur) throws Exception {
        int i = 2;
        double koef1 = 0;
        while (i <= 27) {
            koef1 += Math.abs(temperatur[i] - temperatur[i + 8]);
            i += 5;
//            System.out.println("2  "+koef1);

        }
        return koef1 / 6;
    }

    /**
     * метод получения коэфициентов разницы три дня назад и сегодняшнего дня
     * @param temperatur массив температур
     * @return
     * @throws Exception
     */
    private double get3days(int[] temperatur) throws Exception {
//        int[] temperatur = getTemp();
        int i = 3;
        double koef1 = 0;
        while (i <= 18) {
            koef1 += Math.abs(temperatur[i] - temperatur[i + 12]);
            i += 5;
        }
        System.out.println(koef1);
        return koef1 / 5;
//        System.out.println(koef1);
    }

    /**
     * метод получения коэфициентов разницы 4ре дня назад и сегодняшнего дня
     * @param temperatur массив температур
     * @return коэфициент
     * @throws Exception
     */
    private double get4days(int[] temperatur) throws Exception {
        int i = 4;
        double koef1 = 0;
        while (i <= 14) {
            koef1 += Math.abs(temperatur[i] - temperatur[i + 16]);
            System.out.println(temperatur[i] + temperatur[i + 16]+ koef1 + i+"  4  ");
            i += 5;
//            System.out.println("4  "+koef1);
        }
        return koef1/3;
    }

    /**
     * метод получения общего коэфициента, для определения точности показанной погоды сайтом
     * @param DB массив темеператур и сопутствующей инфы в файлике
     * @return коэфициент
     */
    public double getBestSuite (DataBaseTxt DB){
        double k=0;
        Double[] car=getKoef(DB);
        for (int i=0;i<5;i++){
            k+=Math.pow(car[i],2);
        }
//        System.out.println(Math.sqrt(k)/4);
        return Math.sqrt(k)/4;
    }
}
