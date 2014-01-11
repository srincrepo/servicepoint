package com.sr.servicepoint.core.repo;

import com.sr.servicepoint.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, String>,
        PagingAndSortingRepository<User, String>, UserRepoCustom {

    User findByUsername(String username);

    List<User> findByName_FirstNameAndName_LastName(String firstName, String lastName);

}
