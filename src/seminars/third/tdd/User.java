package seminars.third.tdd;

public class User {

    String name;
    String password;


    boolean isAuthenticate = false;
    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public void authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            isAuthenticate =true;
        }
        else {
            isAuthenticate = false;
            }
    }


}