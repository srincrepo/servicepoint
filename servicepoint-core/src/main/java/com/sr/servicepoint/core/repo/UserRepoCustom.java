package com.sr.servicepoint.core.repo;

import com.sr.servicepoint.core.entity.User;

import java.util.List;

public interface UserRepoCustom {

    List<User> searchUsers(String firstName, String lastName);

}
