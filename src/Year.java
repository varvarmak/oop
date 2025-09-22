public class Year {
    private int yearNumber;
    private Month[] months;

    public Year(int yearNumber) {
        this.yearNumber = yearNumber;
        this.months = new Month[13]; // индексы 0 12 используем 1 12
    }

    public int getYearNumber() {
        return yearNumber;
    }
    public Month getMonth(int monthNumber) {
        if (months[monthNumber] == null) {
            months[monthNumber] = new Month(monthNumber);//еще не тестилось
        }
        return months[monthNumber];
    }
    public int getTotalEvents() {
        int total = 0;
        for (int i = 1; i <= 12; i++) {
            if (months[i] != null) {
                total += months[i].getTotalEvents();
            }
        }
        return total;
    }

    public void addEvent(int monthNumber, int dayNumber, String time, String title, String description) {
        Month month = getMonth(monthNumber);
        month.addEvent(dayNumber, time, title, description);
    }

}
