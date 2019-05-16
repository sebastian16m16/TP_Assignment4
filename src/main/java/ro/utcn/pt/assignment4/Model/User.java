package ro.utcn.pt.assignment4.Model;

public class User {

    protected int user_id;
    protected String user_name;
    protected String user_last_name;
    protected Boolean status;

    public User() {
    }

    public User(int user_id, String user_name, String user_last_name, Boolean status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.status = status;
    }

    public User(String user_name, String user_last_name, Boolean status) {
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
