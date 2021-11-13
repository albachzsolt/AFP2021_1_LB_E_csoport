package webshop.user;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int enabled;
    private UserRole userRole;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getEnabled() {
        return enabled;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
