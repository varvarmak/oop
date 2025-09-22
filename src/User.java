public class User {
    private int id;
    private String name;
    private Year[] years;
    private static final int START_YEAR = 2025; // начальный год
    private static final int TOTAL_YEARS = 100;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.years = new Year[TOTAL_YEARS];
    }
    public Year getYear(int yearNumber) {
        int index = yearNumber - START_YEAR;

        if (index < 0 || index >= TOTAL_YEARS) {
            throw new IllegalArgumentException("Неверный год: " + yearNumber);
        }

        if (years[index] == null) {
            years[index] = new Year(yearNumber);
        }
        return years[index];
    }
    public int getTotalEvents() {
        int total = 0;
        for (Year year : years) {
            if (year != null) {
                total += year.getTotalEvents();
            }
        }
        return total;
    }
}
