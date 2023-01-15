package view;

import model.Calculate;
import model.DataBaseTxt;
import model.DrawGraph;
import model.gr;

import java.util.Arrays;
import java.util.List;

/**
 * класс определяющий, который график строить
 */
public class Graph {
//    List<String> captions = Arrays.asList("0", "1", "2", "3");
//    List<Integer> LinkedList_RemoveMedian = Arrays.asList(1356500, 11371400, 99536300, 779732200);

    /**
     * мотод определяет который график строить
     * @param i
     * @param debug
     */
   public void DrawGraphs(int i,boolean debug){
       gr Graph=new gr();
        switch (i){
            case 1:
                DataBaseTxt DB = new DataBaseTxt("./Test.txt");
                Calculate ca = new Calculate();
                Graph.createAndShowGui(ca.getKoef(DB),debug,"www.pogoda.spb.ru");
                break;
            case 2:
                DataBaseTxt DB2 = new DataBaseTxt("./Test2.txt");
                Calculate ca2 = new Calculate();
                Graph.createAndShowGui(ca2.getKoef(DB2),debug,"world-weather.ru");
                break;
            default:
                break;
        }

//        List<String> captions = Arrays.asList("1", "2", "3", "4");
//
//        List<Integer> ArrayList_AddMedian = Arrays.asList(5, 13, 15,30);
//        DrawGraph.createAndShowGui(ArrayList_AddMedian, captions, "ArrayList_AddMedianTime");
    }
}
