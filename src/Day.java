public class Day {
    private int dayNumber;    // номер дня 1-31
    //private int weekday;      // день недели (0-понедельник, и тд)
    private Event[] events;   // массив дел на день (48)

    public Day(int dayNumber) {
        this.dayNumber = dayNumber;
        //this.weekday = weekday;
        this.events = new Event[24];
    }

    public void addEvent(String time, String title, String comm) {
        // время в номер часа
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        if ((hour < 0 || hour > 23)||(minute < 0 || minute > 59)) {
            throw new IllegalArgumentException("неверное время: " + time);
        }

        events[hour] = new Event(time, title, comm);
    }
    public int getDayNumber() { return dayNumber; }

    // НОВЫЙ МЕТОД: получить массив событий
    public Event[] getEvents() {
        return events;
    }
//    public String getWeekdayName() {
//        String[] weekdays = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
//        return weekdays[weekday];
//    }

    public Event getEvent(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        return events[hour];
    }

    public int getEventsCount() {
        int count = 0;
        for (Event event : events) {
            if (event != null) {
                count++;
            }
        }
        return count;
    }

    public String messageDay() {
        return "День " + dayNumber + ", дел: " + getEventsCount();
    }
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(messageDay()).append("\n");

    for (Event e : events) {
        if (e != null) {
            sb.append(" ").append(e.massageEvent()).append("\n");
            }
        }
        return sb.toString();
    }
}
