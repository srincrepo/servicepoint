package com.solutionsresource.servicepoint.core.service.impl;

import com.solutionsresource.servicepoint.core.dto.UserInfo;
import com.solutionsresource.servicepoint.core.entity.Name;
import com.solutionsresource.servicepoint.core.entity.User;
import com.solutionsresource.servicepoint.core.exception.UserNotFoundException;
import com.solutionsresource.servicepoint.core.repo.UserRepo;
import com.solutionsresource.servicepoint.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void saveUser(UserInfo userInfo) {
        userRepo.save(toUserInfo(userInfo));
    }

    @Override
    public UserInfo getUser(String username) throws UserNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return toUser(user);
    }

    private User toUserInfo(UserInfo userInfo) {
        User user = new User();
        user.setUsername(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        user.setName(new Name(userInfo.getFirstName(),
                userInfo.getMiddleInitial(), userInfo.getLastName()));
        //TODO map contacts
        return user;
    }

    private UserInfo toUser(User user) {
        UserInfo userInfo = new UserInfo();
        Name name = user.getName();
        if (name != null) {
            userInfo.setFirstName(name.getFirstName());
            userInfo.setMiddleInitial(name.getMiddleInitial());
            userInfo.setLastName(name.getLastName());
        }
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword(user.getPassword());
        //TODO map contacts
        return userInfo;
    }

}
