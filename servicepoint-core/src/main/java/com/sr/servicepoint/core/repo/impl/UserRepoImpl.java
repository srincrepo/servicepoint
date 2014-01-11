package com.sr.servicepoint.core.repo.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.sr.servicepoint.core.entity.User;
import com.sr.servicepoint.core.repo.UserRepoCustom;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static com.sr.servicepoint.core.entity.QUser.user;

public class UserRepoImpl extends QueryDslRepositorySupport implements UserRepoCustom {

    public UserRepoImpl() {
        super(User.class);
    }

    @Override
    public List<User> searchUsers(String firstName, String lastName) {
        JPQLQuery query = from(user);

        if (firstName != null) {
            query.where(user.name.firstName.eq(firstName));
        }

        if (lastName != null) {
            query.where(user.name.lastName.eq(lastName));
        }

        return query.list(user);
    }

}
