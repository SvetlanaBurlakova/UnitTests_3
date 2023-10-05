package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;
    @BeforeEach
    void setup(){
        user = new User("Ivan", "123",false);
    }
    @Test
    void authenticateTrue(){
        user.authenticate("Ivan","123");
        assertTrue(user.isAuthenticate);
    }
    @Test
    void authenticateFalse(){
        user.authenticate("Ivan","124");
        assertFalse(user.isAuthenticate);
    }

    @Test
    void userAdded(){
        UserRepository userRepository = new UserRepository();
        user.authenticate("Ivan","123");
        assertFalse(userRepository.findByName(user.name));
        userRepository.addUser(user);
        assertTrue(userRepository.findByName(user.name));
    }
    @Test
    void userNotAddedDueToInList(){
        UserRepository userRepository = new UserRepository();
        user.authenticate("Ivan","123");
        userRepository.addUser(user);
        assertThrows(RuntimeException.class, ()-> userRepository.addUser(user), "Пользователь уже зарегестрирован!");
    }
    @Test
    void userNotAddedDueAuthenificationError(){
        UserRepository userRepository = new UserRepository();
        user.authenticate("Ivan","124");
        assertThrows(RuntimeException.class, ()-> userRepository.addUser(this.user), "Не правильный логин или пароль");
    }
    @Test
    void logOutNotAdminUsersNotAdmin(){
        UserRepository userRepository = new UserRepository();
        User admin = new User("Sergey", "345",true);
        user.authenticate("Ivan","123");
        admin.authenticate("Sergey","345");
        userRepository.addUser(user);
        userRepository.addUser(admin);
        assertTrue(user.isAuthenticate);
        userRepository.logOutNotAdminUsers();
        assertFalse(user.isAuthenticate);
    }
    @Test
    void logOutNotAdminUsersAdmin(){
        UserRepository userRepository = new UserRepository();
        User admin = new User("Sergey", "345",true);
        user.authenticate("Ivan","123");
        admin.authenticate("Sergey","345");
        userRepository.addUser(user);
        userRepository.addUser(admin);
        assertTrue(admin.isAuthenticate);
        userRepository.logOutNotAdminUsers();
        assertTrue(admin.isAuthenticate);
    }

}