package controller;

public class UserRoleContext {


    private static String userRole;
    private static String email;

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String role) {
        userRole = role;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String mail) {
        email = mail;
    }

}

