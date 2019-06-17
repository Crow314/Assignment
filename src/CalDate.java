public class CalDate {
    private int year;
    private int month;
    private int day;
    private String dayOfWeek;

    CalDate(int year, int month, int day){
        this.change(year, month, day);
    }

    CalDate(CalDate arg){
        this(arg.getYear(), arg.getMonth(), arg.getDay());
    }

    public void  change(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = zeller(year, month, day);
    }

    private String zeller(int year, int month, int day){
        final String[] DAY_OF_WEEK = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        //1月を前年の13月, 2月を前年の14月として計算する
        if(month == 1 || month == 2){
            year--;
            month += 12;
        }

        int dayOfWeek_int = (year + year/4 - year/100 + year/400 + (13 * month + 8)/5 + day) % 7;
        return DAY_OF_WEEK[dayOfWeek_int];
    }

    public boolean isSameWith(CalDate d){
        if(this.getYear() == d.getYear() && this.getMonth() == d.getMonth() && this.getDay() == d.getDay()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getYear() + "/" + this.getMonth() + "/" + this.getDay() + "(" + this.dayOfWeek + ")";
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
