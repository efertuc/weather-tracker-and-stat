package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * класс отвечающий за хранение, заипсь и чтения данных
 */
public class DataBaseTxt {
    static int ID = 0;

    /**
     * запись в файл инфы
     * @param path путь к файлу
     */
    public DataBaseTxt(String path) {
        _path = path;

        File file = new File(_path);
        if (file.exists()) {
            try {
                _dataIn = new BufferedReader(new FileReader(_path));

                String tmp;
                while ((tmp = _dataIn.readLine()) != "" && tmp != null) {
                    if (tmp.indexOf("ID:") >= 0) {
                        ID = Integer.parseInt(tmp.substring(tmp.indexOf(':') + 2, tmp.length() - 1));
                    }
                }
            } catch (IOException exc) {
                System.err.println("Ошибка записи в файл!");
            } catch (NumberFormatException exp) {
                System.err.println("Некорректный ID");
            }

            ID++;
        }
    }

    public DataBaseTxt() {

    }

    /**
     * метод для логирования данных в бд
     * @param level индетификатор логирования
     * @param message логируемое сообщение
     */
    public static void Log_File(String level, String message) {
        File file3 = new File("LogFile.txt");
        LocalTime timer = LocalTime.now();
        switch(level){
            case "INFO":
                try {
                    file3.createNewFile();
                    FileWriter DataFile3 = new FileWriter(file3,true);
                    DataFile3.write(LocalDate.now() + "| " + timer.getHour( )+ ":" + timer.getMinute( )+ ":" + timer.getSecond() + "| " + "INFO:" + " " + message + "\n");
                    DataFile3.close();
                }
                catch(IOException ex) {
                    Log_File("WARN", "Метод Eat_herbi IOException ex" );
                }
                break;
            case "WARN":
                try {
                    file3.createNewFile();
                    FileWriter DataFile3 = new FileWriter(file3,true);
                    DataFile3.write(LocalDate.now() + "| " + timer.getHour( )+ ":" + timer.getMinute( )+ ":" + timer.getSecond() + "| " + "-WARN:" + " " + message + "\n");
                    DataFile3.close();
                }
                catch(IOException ex) {
                    //Log_File("WARN", "Метод Eat_herbi IOException ex" );
                }
                break;
            case "ERROR":
                try {
                    file3.createNewFile();
                    FileWriter DataFile3 = new FileWriter(file3,true);
                    DataFile3.write(LocalDate.now() + "| " + timer.getHour( )+ ":" + timer.getMinute( )+ ":" + timer.getSecond() + "| " + "--ERROR:" + " " + message + "\n");
                    DataFile3.close();
                }
                catch(IOException ex) {
                    Log_File("WARN", "Метод Eat_herbi IOException ex" );
                }
                break;
        }
    }

    /**
     * метод для записи данных
     * @param data информация
     * @return индекс записи
     * @throws IOException
     */
    public int write2File(String data) throws IOException {
        try {
            _dataOut = new FileWriter(_path, true);
            _dataOut.append("\nID: " + ID + ";\n");
            _dataOut.append(data);
        } catch (IOException exc) {
            System.err.println("Ошибка записи в файл!");
            return -1;
        } finally {
            _dataOut.close();
        }
        return ++ID;
    }

    /**
     * метод чтения текстовых файлов
     * @param id индекс элемента
     * @return необходимый элемент из бд
     */
    public Map<String, String> read4File(int id) {
        System.out.println(id);
        Map<String, String> result = new HashMap<String, String>();
        try {
            _dataIn = new BufferedReader(new FileReader(_path));
            String tmp;
            boolean start = false;
            while ((tmp = _dataIn.readLine()) != "" && tmp != null) {
                if (tmp.indexOf("ID: " + id + ";") >= 0) {
                    start = true;
                    continue;
                } else if (tmp.indexOf("ID") >= 0 && start) {
                    break;
                }

                if (start) {
                    String key, value;
                    if (tmp.indexOf("::") >= 0) {
                        key = tmp.substring(0, tmp.indexOf("::")).trim();
                        value = tmp.substring(tmp.indexOf("::") + 2, tmp.length());

                        if (!key.isEmpty() && !value.isEmpty()) {
                            result.put(key, value);
                        }
                    } else if (tmp.indexOf(":") >= 0) {
                        key = tmp.substring(0, tmp.indexOf(":")).trim();
                        value = tmp.substring(tmp.indexOf(":") + 2, tmp.length() - 1);

                        if (!key.isEmpty() && !value.isEmpty()) {
                            result.put(key, value);
                        }
                    }
                }
            }
        } catch (IOException exc) {
            System.err.println("Ошибка записи в файл!");
        } catch (NumberFormatException exp) {
            System.err.println("Некорректный ID");
        }

        return result;
    }

    /**
     * метод удаления инфы из текстового файла, лол
     * @param id индекс элемента, кек
     * @return инфа по удалению, чебурек
     * @throws IOException
     */
    public boolean remove4File(int id) throws IOException {
        boolean result = false;

        try {
            _dataIn = new BufferedReader(new FileReader(_path));
            _dataOut = new FileWriter("./tmp.txt", false);

            String tmp;
            boolean start = false;
            while ((tmp = _dataIn.readLine()) != "" && tmp != null) {
                if (tmp.indexOf("ID: " + id + ";") >= 0) {
                    start = true;
                    continue;
                } else if (tmp.indexOf("ID") >= 0 && start) {
                    start = false;
                    result = true;
                }

                if (!start) {
                    _dataOut.write(tmp + "\n");
                }
            }
        } catch (IOException exc) {
            System.err.println("Ошибка записи в файл!");
        } catch (NumberFormatException exp) {
            System.err.println("Некорректный ID");
        } finally {
            _dataOut.close();
        }

        if (result) {
            return true;
        }
        return false;
    }



    private BufferedReader _dataIn;
    private FileWriter _dataOut;
    private String _path;
}
