package com.EWallet.Venmo.service;

import com.EWallet.Venmo.models.User;
import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public User getUserById(int id);
    public User addUser(User user);
    public User deleteUser(int id);
    public User update(int id, User user);


}
