package com.ShawnYin.WSP.service;

import com.ShawnYin.WSP.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    int getUserNum();

    int getUser(String username, String password);

    void userRegister(User user);

    boolean getUserByName(String username);

    int getDownloadPermission(int userID);

}
