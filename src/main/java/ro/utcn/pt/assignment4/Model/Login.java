package ro.utcn.pt.assignment4.Model;

/**
 * This Class defines the Login object
 */
public class Login {

    protected int login_id;
    protected String username;
    protected String password;
    protected int user_id;


    public Login() {
    }

    /**
     * Constructor 2
     * @param login_id
     * @param username
     * @param password
     * @param user_id
     */
    public Login(int login_id, String username, String password, int user_id) {
        this.login_id = login_id;
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    /**
     * Constructor 3
     * @param username
     * @param password
     * @param user_id
     */
    public Login(String username, String password, int user_id) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    /**
     * Gets the login Id
     * @return login id
     */
    public int getLogin_id() {
        return login_id;
    }

    /**
     * Sets the login Id
     * @param login_id
     */
    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    /**
     * Gets the username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets The username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the Password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user_id
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * sets the user ID
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
