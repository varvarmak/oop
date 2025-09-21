public class Month {
    private int monthNumber;          // номер месяца (1-12)
    private int daysInMonth;          // количество дней в месяце
    private Day[] days;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] MONTH_NAMES = {"", "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public Month(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Неверный номер месяца: " + monthNumber);
        }

        this.monthNumber = monthNumber;
        this.daysInMonth = DAYS_IN_MONTH[monthNumber];
        this.days = new Day[daysInMonth + 1];
    }

    public int getMonthNumber() { return monthNumber; }
    public int getDaysInMonth() { return daysInMonth; }
    public String getMonthName() {
        return MONTH_NAMES[monthNumber];
    }
    public Day getDay(int dayNumber) {
        if (dayNumber < 1 || dayNumber > daysInMonth) {
            throw new IllegalArgumentException("Неверный номер дня: " + dayNumber);
        }

        if (days[dayNumber] == null) {
            days[dayNumber] = new Day(dayNumber);
        }
        return days[dayNumber];
    }
    public static String getMonthName(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Неверный номер месяца: " + monthNumber);
        }
        return MONTH_NAMES[monthNumber];
    }
    public int getTotalEvents() {
        int total = 0;
        for (int i = 1; i <= daysInMonth; i++) {
            if (days[i] != null) {
                total += days[i].getEventsCount();
            }
        }
        return total;
    }

    public void addEvent(int dayNumber, String time, String title, String comm) {
        Day day = getDay(dayNumber);
        day.addEvent(time, title, comm);
    }

}
