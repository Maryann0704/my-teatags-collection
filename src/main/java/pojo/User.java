package pojo;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private long role_id;

    public User() {
    }

    public User(long id, String login, String password, String email, long roles_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
