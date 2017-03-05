package geosolar.domain;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

@SuppressWarnings("unused")
@Table(keyspace = "geosolar", name = InterplanetaryMagneticFieldValue.INTERPLANETARY_MAGNETIC_FIELD_VALUE_TABLE,
        readConsistency = "QUORUM",
        writeConsistency = "QUORUM"
)
public class InterplanetaryMagneticFieldValue {

    public static final String INTERPLANETARY_MAGNETIC_FIELD_VALUE_TABLE = "interplanetary_magnetic_field_values";

    public static final String ID_COLUMN = "id";
    public static final String YEAR_COLUMN = "YR";
    public static final String MONTH_COLUMN = "MO";
    public static final String DAY_COLUMN = "DA";
    public static final String TIME_COLUMN = "HHMM";
    public static final String BZ_COLUMN = "Bz";
    @PartitionKey
    @Column(name = ID_COLUMN)
    private UUID id;
    @Column(name = YEAR_COLUMN)
    private int year;
    @Column(name = MONTH_COLUMN)
    private int month;
    @Column(name = DAY_COLUMN)
    private int day;
    @Column(name = TIME_COLUMN)
    private int hhmm;
    @Column(name = BZ_COLUMN)
    private double bz;

    public InterplanetaryMagneticFieldValue(UUID id, int year, int month, int day, int hhmm, double bz) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hhmm = hhmm;
        this.bz = bz;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
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
