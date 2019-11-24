package util;

public class Patterns {
    public static final String LOGIN = "[a-zA-Z0-9._]{5,15}";
    public static final String PASSWORD = "[a-zA-Z0-9._]{5,50}";
    public static final String EMAIL = "[a-zA-Z0-9._]+@[a-z]+.[a-z]{2,3}";
    public static final String TRADEMARK = "[a-zA-Z0-9._\\s]+";
    public static final String SUBTITLE = "[a-zA-Z0-9._\\s]+";
    public static final String NUMBER_IN_CATALOG = "[\\d]{2}-[\\d]{1,3}-\\d";
}
