package model;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * класс для чтения пропертей
 */
public class ReadProperties {

    /**
     * метод чтения пропертей
     * @return инфа из пропертей
     * типа пароль логин логинКаунт и арзное другое
     * @throws IOException
     */
    public static String[] Example1() throws IOException
    {
        String[] info=new String[6];
        try{
            Properties props = new Properties();
            props.load(new FileInputStream(new File("C:/Users/Victory/IdeaProjects/untitled3/scratch.properties")));

            info[0] = props.getProperty("login");
            info[1] = props.getProperty("password");
            info[2] = props.getProperty("log_count");
            info[3] = props.getProperty("log");
            info[4] = props.getProperty("pas" );
            info[5] = props.getProperty("log_count2");


            //Предположим, что в настройках находится список целых через точку с запятой

            System.out.println(props.toString());
            System.out.println(Arrays.toString(info));
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return info;
        }
    }


    public static void ReadProperties(){
//        String login = " ";
//        String password = " ";
//        String line;
//        int i=0;
//
//        try {
//            Path path = Paths.get("C:\\Users\\Victory\\IdeaProjects\\untitled3\\settings.property");
//            Scanner scan = new Scanner(path);
////            String line1 = scan.nextLine();
//
//            while (scan.hasNextLine()){
//                String line1 = scan.nextLine();
//                for(login = line1; scan.hasNextLine(); password = line) {
//                    line = scan.nextLine();
//                }
//                getInfo(login);
//                info[i]=login;
//                i++;
//                System.out.println(login);
//
//            }
//            scan.close();
//        } catch (IOException var13) {
//            DataBaseTxt.Log_File("WARN", "Метод LogIn IOException ex");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        String pruf1 = "admin";
//        line = "admin";
//        boolean zapis;
//        File file;
//        FileWriter DataFile;
//        if (pruf1.equals(login) & line.equals(password)) {
//            zapis = true;
//            file = new File("LoginOf.txt");
//
//            try {
//                file.createNewFile();
//                DataFile = new FileWriter(file, false);
//                DataFile.write("1");
//                DataFile.close();
////                Login.dispose();
////                //Открыть Меню
////                MenuWin qwe = new MenuWin();
////                qwe.menuWin();
//            } catch (IOException var12) {
//                DataBaseTxt.Log_File("WARN", "Метод LOGIN IOException ex");
//            }
//        } else {
//            zapis = false;
//            file = new File("LoginOf.txt");
//
//            try {
//                file.createNewFile();
//                DataFile = new FileWriter(file, false);
//                DataFile.write("0");
//                DataFile.close();
//                System.out.println("Неверный логин или пароль...");
//                System.exit(1);
//            } catch (IOException var11) {
//                DataBaseTxt.Log_File("WARN", "Метод LOGIN IOException ex");
//            }
//        }
//
//        DataBaseTxt.Log_File("INFO", "Loggin____________________");
//

    }


//    public static void main(String[] args) throws Exception {
//        Example1();
////        ReadProperties();
//    }
}
