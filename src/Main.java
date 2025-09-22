//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
import java.util.Scanner;
public class Main {
    private User currentUser;
    private Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("=== ПЛАНИРОВЩИК ДЕЛ ===");
        authenticateUser();
        showMainMenu();
    }
    private void authenticateUser() {
        System.out.print("Привет! Как тебя зовут? ");
        String name = scanner.nextLine();

        //пока так ляляляляля
        currentUser = new User(1, name);
        System.out.println("Привет, " + name + "! Готов к работе!");
    }
    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Добавить дело");
            System.out.println("2. Посмотреть дела");
            System.out.println("3. Статистика");
            System.out.println("4. Выйти");
            System.out.print("Выбери действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addEvent();
                    break;
                case "2":
                    viewEvents();
                    break;
                case "3":
                    showStatistics();
                    break;
                case "4":
                    System.out.println("Пока! Возвращайся скорее!");
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуй еще раз.");
            }
        }
    }

    private void addEvent() {
        System.out.println("\n--- ДОБАВЛЕНИЕ ДЕЛА ---");

        try {
            System.out.print("Год (2024-2099): ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Месяц (1-12): ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.print("День: ");
            int day = Integer.parseInt(scanner.nextLine());

            System.out.print("Время (например, 14:30): ");
            String time = scanner.nextLine();

            System.out.print("Название дела: ");
            String title = scanner.nextLine();

            System.out.print("Описание: ");
            String description = scanner.nextLine();

            // Получаем нужный день через цепочку
            Year yearObj = currentUser.getYear(year);
            Month monthObj = yearObj.getMonth(month);
            Day dayObj = monthObj.getDay(day);

            // Добавляем дело
            dayObj.addEvent(time, title, description);

            System.out.println("Дело добавлено!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void viewEvents() {
        System.out.println("\n--- ПРОСМОТР ДЕЛ ---");

        try {
            System.out.print("Год (2024-2099): ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Месяц (1-12): ");
            int month = Integer.parseInt(scanner.nextLine());

            System.out.print("День: ");
            int day = Integer.parseInt(scanner.nextLine());

            // Получаем нужный день
            Year yearObj = currentUser.getYear(year);
            Month monthObj = yearObj.getMonth(month);
            Day dayObj = monthObj.getDay(day);

            // Показываем дела
            System.out.println("\nДела на " + day + "." + month + "." + year + ":");
            System.out.println("Всего дел: " + dayObj.getEventsCount());

            Event[] events = dayObj.getEvents();
            for (int i = 0; i < events.length; i++) {
                if (events[i] != null) {
                    System.out.println(events[i].getTime() + " - " +
                            events[i].getTitle() + " (" +
                            events[i].getComm() + ")");
                }
            }
                  } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    private void showStatistics() {
        System.out.println("\n--- СТАТИСТИКА ---");
        System.out.println(currentUser);
        System.out.println("Всего дел: " + currentUser.getTotalEvents());
    }
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

}
}
