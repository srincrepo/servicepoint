package com.solutionsresource.servicepoint.core.service;

import com.solutionsresource.servicepoint.core.dto.UserInfo;
import com.solutionsresource.servicepoint.core.exception.UserNotFoundException;

public interface UserService {

    void saveUser(UserInfo userInfo);

    UserInfo getUser(String username) throws UserNotFoundException;

}
