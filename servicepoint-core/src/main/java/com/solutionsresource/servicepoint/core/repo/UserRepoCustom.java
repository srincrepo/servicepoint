package com.solutionsresource.servicepoint.core.repo;

import com.solutionsresource.servicepoint.core.entity.User;

import java.util.List;

public interface UserRepoCustom {

    List<User> searchUsers(String firstName, String lastName);

}
