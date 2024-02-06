package controller;

public class UserRoleContext {


    private static String userRole;

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String role) {
        userRole = role;
    }
}

