import java.util.HashMap;

public class Month {
    private int monthNumber;          // номер месяца (1-12)
    private int daysInMonth;          // количество дней в месяце
    private Map<Integer, Day> days;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final String[] MONTH_NAMES = {"", "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public Month(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Неверный номер месяца: " + monthNumber);
        }

        this.monthNumber = monthNumber;
        this.daysInMonth = DAYS_IN_MONTH[monthNumber];
        this.days = new HashMap<>(); // пустой словарь
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

        if (!days.contaunsKey(dayNumber)) {
            days.put(dayNumber, new Day(dayNumber));
        }
        return days.get(dayNumber);
    }
    public void addEvent(int dayNumber, String time, String title, String comm) {
        Day day = detDay(dayNumber);
        day.addEvent(time, title, comm);
    }
    
    public int getTotalEvents() {
        int total = 0;
        for (Day : days.values()) {
            total += d.getEventCount();
        }
        return total;
    }

    public void addEvent(int dayNumber, String time, String title, String comm) {
        Day day = getDay(dayNumber);
        day.addEvent(time, title, comm);
    }

}
