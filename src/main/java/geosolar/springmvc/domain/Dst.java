package geosolar.springmvc.domain;

public class Dst {

    private int year;
    private int month;
    private int day;
    private int hour;
    private double value;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Dst(int year, int month, int day, int hour, double value) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.value = value;
    }
}