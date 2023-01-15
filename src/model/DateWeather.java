package model;

/**
 * класс для представления информации о погоде
 */
public class DateWeather {
    private String dateNow;
    private String date;
    private String temp;
    public DateWeather(){}
    public DateWeather(String dateNow, String date, String temp) {
        setDateNow(dateNow);
        setDate(date);
        setTemp(temp);

    }

    public void setDateNow(String dateNow) {
       this.dateNow = dateNow;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }

    private String getDateNow() {
        return dateNow;
    }
    private String getDate() {
        return date;
    }
    private String getTemp() {
        return temp;
    }

    /**
     *  метод представления информации
     * @return стринговую строку
     */
    @Override
    public String toString() {
        String Result = "dateNow: "+this.getDateNow()+";\r\n";
        Result += "\tdate: "+this.getDate()+";\r\n";
        Result += "\ttemp: "+this.getTemp()+";\r\n";
        return Result;
    }
}
