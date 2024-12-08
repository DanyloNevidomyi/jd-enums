package learning.java;

public class UserHistoryApp {
    public static void main(String[] args) {
        UserHistory history = new UserHistory();

        history.addAction("user1", Action.LOGIN);
        history.addAction("user1", Action.VIEWED_PAGE);
        history.addAction("user1", Action.LOGOUT);

        history.addAction("user2", Action.LOGIN);
        history.addAction("user2", Action.UPDATED_PROFILE);

        history.addAction("admin", Action.LOGIN);
        history.addAction("admin", Action.DELETED_ACCOUNT);

        history.displayAllActions();
    }
}
