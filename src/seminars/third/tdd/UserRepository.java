package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate && this.findByName(user.name) == false) {
            data.add(user);
        } else if (user.isAuthenticate &&this.findByName(user.name) == true) {
            throw new RuntimeException("Пользователь уже зарегестрирован!");
        }
        else if (user.isAuthenticate == false) {
            throw  new RuntimeException("Не правильный логин или пароль");
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutNotAdminUsers(){
        for (User user : data) {
            if (user.isAdmin == false) {
                user.isAuthenticate = false;
            }
        }
    }

}