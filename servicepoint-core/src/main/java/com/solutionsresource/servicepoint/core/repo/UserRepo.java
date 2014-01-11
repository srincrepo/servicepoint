package com.solutionsresource.servicepoint.core.repo;

import com.solutionsresource.servicepoint.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String>,
        PagingAndSortingRepository<User, String> {

    User findByUsername(String username);

    List<User> findByName_FirstNameAndName_LastName(String firstName, String lastName);

}
