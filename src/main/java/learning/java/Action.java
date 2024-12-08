package learning.java;

public enum Action {
    LOGIN("Увійшов у систему"),
    LOGOUT("Вийшов із системи"),
    VIEWED_PAGE("Переглянув сторінку"),
    UPDATED_PROFILE("Оновив профіль"),
    DELETED_ACCOUNT("Видалив обліковий запис");

    private final String description;

    Action(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
