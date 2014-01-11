package com.solutionsresource.servicepoint.core.service;

import com.solutionsresource.servicepoint.core.config.CoreConfig;
import com.solutionsresource.servicepoint.core.dto.UserInfo;
import com.solutionsresource.servicepoint.core.entity.User;
import com.solutionsresource.servicepoint.core.exception.UserNotFoundException;
import com.solutionsresource.servicepoint.core.repo.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class}, loader = AnnotationConfigContextLoader.class)
public class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @Autowired
    @InjectMocks
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

/*    @Configuration
    static class RepoContextConfig {

        @Bean
        public UserRepo userRepo() {
            return new UserRepo() {
                @Override
                public void save(User user) {
                }

                @Override
                public User findByUsername(String username) {
                    return null;
                }
            };
        }

    }*/

    @Test
    public void testSaveUser() {
        UserInfo userInfo = new UserInfo();
        userService.saveUser(userInfo);
        verify(userRepo, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserByUsernameWhenFound() {
        String username = "admin";

        User user = new User();
        user.setUsername(username);
        when(userRepo.findByUsername(username)).thenReturn(user);

        UserInfo userInfo = null;
        try {
            userInfo = userService.getUser(username);
        } catch (UserNotFoundException e) {
            fail();
        }

        assertNotNull(userInfo);
        assertEquals(username, userInfo.getUsername());
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetUserByUsernameWhenNotFound() throws UserNotFoundException {
        String username = "admin";
        userService.getUser(username);
    }

}
