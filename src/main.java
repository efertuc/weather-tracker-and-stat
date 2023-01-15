import controller.ParsingSuiteFirst;
import controller.ParsingSuiteSecond;
import view.StartWin;

/**
 * @author Kononova Victoria
 */
public class main {
    /**
     * Класс-начало, точка входа в программу
     * Здесь мы вызываем основные контейнеры для:
     * 1) парсинга данных
     * 2) запуска интерфейса
     * 3) авторизации
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//
        new ParsingSuiteFirst();
        new ParsingSuiteSecond();
        StartWin.LoginWin();
//        int j = 1;
//        Graph Dg = new Graph();
//        Dg.DrawGraphs(j);
//        DataBaseTxt DB = new DataBaseTxt("./Test.txt");
//
//        DB.read4File(27);
//        DB.read4File(35);
//        System.out.println(DB.read4File(24));
////        DataBaseTxt DB2 = new DataBaseTxt("./Test2.txt");
//        Calculate ca=new Calculate();
////        ca.getKoef(DB);
//        String[] date = new String[40];
//        int[] temp = new int[40];
//        int res;
//
//            for (int i = 0; i < temp.length-1; i++) {
//                date[i] = String.valueOf(DB.read4File(i));
//                String[] rtt = new String[3];
//                rtt = date[i].split(" ");
//                res = ca.getTempFromString(rtt[1]);
//                System.out.println(res+"   "+i);
//                temp[i] = res;
//            }
//            System.out.println(Arrays.toString(temp));
//            return temp;





//
//
//        System.out.println(ca.getBestSuite(DB)+"   "+ca.getBestSuite(DB2));
//
//        ParsingWeatherZe PZ=new ParsingWeatherZe();
//        System.out.println(PZ.getDate());

//        gr Graph=new gr();

//        Calculate ca = new Calculate();
//        double k=0;
//        Double[] car=ca.getKoef(DB);
//        for (int i=0;i<5;i++){
//            k+=Math.pow(car[i],2);
//        }
//        System.out.println(Math.sqrt(k)/4);
//
//        Calculate ca2 = new Calculate();
//        double k2=0;
//        Double[] car2=ca2.getKoef(DB2);
//        for (int i=0;i<5;i++){
//            k2+=Math.pow(car2[i],2);
//        }
//        System.out.println(Math.sqrt(k2)/4);
//        Graph.createAndShowGui(ca.getKoef(DB));

////
//
//
//
//        Calculate ca1 = new Calculate();
//        Calculate ca2 = new Calculate();
//        Calculate ca3 = new Calculate();
//
//        System.out.println(Arrays.toString(ca.getKoef(DB)));
//        System.out.println(Arrays.toString(ca1.getKoef(DB2)));
//        ca.getPrevius();
//        ca1.get2days();
//        ca2.get3days();
//        ca.get4days();
//

//       delete.OWMJsonParser test=new delete.OWMJsonParser();
//       test.getReadyForecast("London");
//        test.getReadyForecast("832");
    }
}
