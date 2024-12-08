package learning.java;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserHistoryTest {
    @Test
    void testAddActionAndRetrieveActions() {
        UserHistory history = new UserHistory();

        history.addAction("user1", Action.LOGIN);
        history.addAction("user1", Action.VIEWED_PAGE);

        List<Action> actions = history.getActions("user1");

        assertEquals(2, actions.size(), "Кількість дій для user1 має бути 2.");
        assertEquals(Action.LOGIN, actions.get(0), "Перша дія має бути LOGIN.");
        assertEquals(Action.VIEWED_PAGE, actions.get(1), "Друга дія має бути VIEWED_PAGE.");
    }

    @Test
    void testGetActionsForUnknownUser() {
        UserHistory history = new UserHistory();

        List<Action> actions = history.getActions("unknown");

        assertTrue(actions.isEmpty(), "Список дій для невідомого користувача має бути порожнім.");
    }

    @Test
    void testAddMultipleUsers() {
        UserHistory history = new UserHistory();

        history.addAction("user1", Action.LOGIN);
        history.addAction("user2", Action.LOGOUT);

        List<Action> actionsUser1 = history.getActions("user1");
        List<Action> actionsUser2 = history.getActions("user2");

        assertEquals(1, actionsUser1.size(), "Кількість дій для user1 має бути 1.");
        assertEquals(1, actionsUser2.size(), "Кількість дій для user2 має бути 1.");
        assertEquals(Action.LOGIN, actionsUser1.get(0), "Дія для user1 має бути LOGIN.");
        assertEquals(Action.LOGOUT, actionsUser2.get(0), "Дія для user2 має бути LOGOUT.");
    }

    @Test
    void testEmptyHistoryDisplay() {
        UserHistory history = new UserHistory();

        assertTrue(history.getActions("anyUser").isEmpty(), "Історія має бути порожньою для будь-якого користувача.");
    }

    @Test
    void testAddSameActionMultipleTimes() {
        UserHistory history = new UserHistory();

        history.addAction("user1", Action.LOGIN);
        history.addAction("user1", Action.LOGIN);

        List<Action> actions = history.getActions("user1");

        assertEquals(2, actions.size(), "Користувач має мати дві дії LOGIN.");
        assertEquals(Action.LOGIN, actions.get(0), "Перша дія має бути LOGIN.");
        assertEquals(Action.LOGIN, actions.get(1), "Друга дія має бути LOGIN.");
    }

}