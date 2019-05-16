package ro.utcn.pt.assignment4.Model;

public class Login {

    protected int login_id;
    protected String username;
    protected String password;
    protected int user_id;


    public Login() {
    }

    public Login(int login_id, String username, String password, int user_id) {
        this.login_id = login_id;
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    public Login(String username, String password, int user_id) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
