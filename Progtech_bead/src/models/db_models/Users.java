package models.models.db_models;

public class Users {
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String address;

    public Users(String username, String password, String email, String first_name, String last_name, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }

    public Users(int id, String username, String password, String email, String first_name, String last_name, String address){
        this(username, password, email, first_name, last_name, address);
        this.id = id;
    }

    public Users() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }
}
