package geosolar.springmvc.domain;

@SuppressWarnings("unused")
public class InterplanetaryMagneticFieldValue {
    private int year;
    private int month;
    private int day;
    private int hhmm;
    private double bz;

    public InterplanetaryMagneticFieldValue(int year, int month, int day, int hhmm, double bz) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hhmm = hhmm;
        this.bz = bz;
    }

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

    public int getHhmm() {
        return hhmm;
    }

    public void setHhmm(int hhmm) {
        this.hhmm = hhmm;
    }

    public double getBz() {
        return bz;
    }

    public void setBz(double bz) {
        this.bz = bz;
    }
}
