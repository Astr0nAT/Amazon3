package models;

public class Date {
    private int _day;
    private int _month;
    private int _year;

    public int get_day() {
        return _day;
    }
    public void set_day(int day) {
        if(day > 0 && day < 32) {
            this._day = day;
        }
    }

    public int get_month() {
        return _month;
    }
    public void set_month(int month) {
        if(month > 0 && month < 13) {
            this._month = month;
        }
    }

    public int get_year() {
        return _year;
    }
    public void set_year(int year) {
        if(year >= 1900) {
            this._year = year;
        }
    }

    public Date(){
        this(1, 1, 1950);
    }

    public Date(int day, int month, int year){
        this.set_day(day);
        this.set_month(month);
        this.set_year(year);
    }

    @Override
    public String toString(){
        return this.get_day() + "." + this.get_month() + "." + this.get_year();
    }

}
