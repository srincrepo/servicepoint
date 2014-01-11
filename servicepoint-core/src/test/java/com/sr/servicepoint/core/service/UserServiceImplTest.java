package com.sr.servicepoint.core.service;

import com.google.common.collect.Lists;
import com.sr.servicepoint.core.config.CoreConfig;
import com.sr.servicepoint.core.dto.UserInfo;
import com.sr.servicepoint.core.entity.Contact;
import com.sr.servicepoint.core.entity.ContactType;
import com.sr.servicepoint.core.entity.User;
import com.sr.servicepoint.core.exception.UserNotFoundException;
import com.sr.servicepoint.core.repo.UserRepo;
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

import java.util.List;

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
        String contactDetail = "11111";
        ContactType contactType = ContactType.HOME;

        User user = new User();
        user.setUsername(username);
        List<Contact> contacts = Lists.newArrayList();
        Contact contact = new Contact();
        contact.setContactType(contactType);
        contact.setDetail(contactDetail);
        contacts.add(contact);
        user.setContacts(contacts);
        when(userRepo.findByUsername(username)).thenReturn(user);

        UserInfo userInfo = null;
        try {
            userInfo = userService.getUser(username);
        } catch (UserNotFoundException e) {
            fail();
        }

        assertNotNull(userInfo);
        assertEquals(username, userInfo.getUsername());
        assertNotNull(userInfo.getContacts());
        assertEquals(1, userInfo.getContacts().size());
        assertEquals(contactDetail, userInfo.getContacts().get(0).getContactDetail());
        assertEquals(contactType.name(), userInfo.getContacts().get(0).getContactType());
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetUserByUsernameWhenNotFound() throws UserNotFoundException {
        String username = "admin";
        userService.getUser(username);
    }

}
