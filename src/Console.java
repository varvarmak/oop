import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private Map<Integer, User> users = new HashMap<>(); // айди
    private User currentUser;
    private Scanner scanner = new Scanner(System.in);
    private int nextUserId = 1;

    public void start() {
        System.out.println("=== ПЛАНИРОВЩИК ДЕЛ ===");

        authenticateUser();
        showMainMenu();
    }

    private void authenticateUser() {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();


        currentUser = null;
        for (User user : users.values()) {
            if (user.getName().equals(name)) {
                currentUser = user;
                break;
            }
        }


        if (currentUser == null) {
            currentUser = new User(nextUserId++, name);
            users.put(currentUser.getId(), currentUser);
            System.out.println("Новый пользователь создан: " + currentUser.getName() + " (id=" + currentUser.getId() + ")");
        } else {
            System.out.println("С возвращением, " + currentUser.getName() + " (id=" + currentUser.getId() + ")!");
        }
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1. Добавить дело");
            System.out.println("2. Посмотреть дела");
            System.out.println("3. Статистика");
            System.out.println("4. Сменить пользователя");
            System.out.println("5. Показать всех пользователей");
            System.out.println("6. Выйти");
            System.out.print("Выбери действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addEvent(); break;
                case "2": viewEvents(); break;
                case "3": showStatistics(); break;
                case "4": authenticateUser(); break;
                case "5": showAllUsers(); break;
                case "6":
                    System.out.println("Пока! Возвращайся скорее!");
                    return;
                default: System.out.println("Неверный выбор! Попробуй ещё раз.");
            }
        }
    }

    private void addEvent() {
        System.out.println("Добавление дела для пользователя " + currentUser.getName());

    }

    private void viewEvents() {
        System.out.println("Просмотр дел пользователя " + currentUser.getName());

    }

    private void showStatistics() {
        System.out.println("Статистика пользователя " + currentUser.getName());
        System.out.println("Всего дел: " + currentUser.getTotalEvents());
    }

    private void showAllUsers() {
        System.out.println("--- Все пользователи ---");
        for (User user : users.values()) {
            System.out.println("id=" + user.getId() + ", имя=" + user.getName());
        }
    }
}
