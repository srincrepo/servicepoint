package com.sr.servicepoint.core.service;

import com.sr.servicepoint.core.dto.UserInfo;
import com.sr.servicepoint.core.exception.UserNotFoundException;

public interface UserService {

    void saveUser(UserInfo userInfo);

    UserInfo getUser(String username) throws UserNotFoundException;

}
