package geosolar.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.opencsv.bean.CsvBindByPosition;

import java.util.UUID;

@SuppressWarnings("unused")
@Table(keyspace = "geosolar", name = Dst.DST_TABLE,
        readConsistency = "QUORUM",
        writeConsistency = "QUORUM"
)
public class Dst {

    public static final String DST_TABLE = "dst";

    public static final String ID_COLUMN = "id";
    public static final String YEAR_COLUMN = "yy";
    public static final String MONTH_COLUMN = "mo";
    public static final String DAY_COLUMN = "da";
    public static final String HOUR_COLUMN = "hh";
    public static final String VALUE_COLUMN = "value";


    @CsvBindByPosition(position = 0)
    @Column(name = YEAR_COLUMN)
    private int year;
    @CsvBindByPosition(position = 1)
    @Column(name = MONTH_COLUMN)
    private int month;
    @CsvBindByPosition(position = 2)
    @Column(name = DAY_COLUMN)
    private int day;
    @CsvBindByPosition(position = 3)
    @Column(name = HOUR_COLUMN)
    private int hour;
    @CsvBindByPosition(position = 4)
    @Column(name = VALUE_COLUMN)
    private double value;
    @PartitionKey
    @Column(name = ID_COLUMN)
    private UUID id;

    public Dst() {

    }

    public Dst(UUID id, int year, int month, int day, int hour, double value) {
        this.id=id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.value = value;
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

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
