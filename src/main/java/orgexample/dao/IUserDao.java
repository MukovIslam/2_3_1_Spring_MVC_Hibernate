package orgexample.dao;

import orgexample.model.User;

import java.util.List;

public interface IUserDao {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser (int id);
    void updateUser(User user);
    void deleteAllUsers();

}
