package com.solutionsresource.servicepoint.core.repo.impl;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.solutionsresource.servicepoint.core.entity.User;
import com.solutionsresource.servicepoint.core.repo.UserRepoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.solutionsresource.servicepoint.core.entity.QUser.user;

public class UserRepoCustomImpl implements UserRepoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> searchUsers(String firstName, String lastName) {
        JPQLQuery query = new JPAQuery(em);

        query.from(user);

        if (firstName != null) {
            query.where(user.name.firstName.eq(firstName));
        }

        if (lastName != null) {
            query.where(user.name.lastName.eq(lastName));
        }

        return query.list(user);
    }

}
