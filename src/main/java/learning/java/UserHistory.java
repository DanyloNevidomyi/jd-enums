package learning.java;

import java.util.*;

public class UserHistory {
    private final Map<String, List<Action>> userActions;

    public UserHistory() {
        this.userActions = new HashMap<>();
    }

    // додавання дії для користувача
    public void addAction(String user, Action action) {
        userActions.putIfAbsent(user, new ArrayList<>());
        userActions.get(user).add(action);
    }

    // список дій для конкретного користувача
    public List<Action> getActions(String user) {
        return userActions.getOrDefault(user, Collections.emptyList());
    }

    // історія всіх дій
    public void displayAllActions() {
        if (userActions.isEmpty()) {
            System.out.println("Немає зареєстрованих дій.");
            return;
        }

        userActions.forEach((user, actions) -> {
            System.out.println("Користувач: " + user);
            actions.forEach(action -> System.out.println(" - " + action.getDescription()));
        });
    }
}
