package com.sr.servicepoint.core.service.impl;

import com.sr.servicepoint.core.dto.UserInfo;
import com.sr.servicepoint.core.entity.User;
import com.sr.servicepoint.core.exception.UserNotFoundException;
import com.sr.servicepoint.core.repo.UserRepo;
import com.sr.servicepoint.core.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Mapper mapper;

    @Override
    public void saveUser(UserInfo userInfo) {
        User user = mapper.map(userInfo, User.class);
        userRepo.save(user);
    }

    @Override
    public UserInfo getUser(String username) throws UserNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return mapper.map(user, UserInfo.class);
    }

}
