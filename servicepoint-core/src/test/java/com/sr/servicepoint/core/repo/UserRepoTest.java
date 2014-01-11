package com.sr.servicepoint.core.repo;

import com.google.common.collect.Lists;
import com.sr.servicepoint.core.config.CoreConfig;
import com.sr.servicepoint.core.config.TestResourceConfig;
import com.sr.servicepoint.core.entity.Contact;
import com.sr.servicepoint.core.entity.ContactType;
import com.sr.servicepoint.core.entity.Name;
import com.sr.servicepoint.core.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, TestResourceConfig.class}, loader = AnnotationConfigContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepoTest {

    private static final String ADMIN = "admin";
    private static final String USER = "user";

    @Autowired
    private UserRepo userRepo;

    @Test
    public void init() {
        User user1 = new User();
        user1.setId(1l);
        user1.setUsername(ADMIN);
        user1.setPassword("");
        user1.setName(new Name("test1", "test1", "test1"));
        userRepo.save(user1);

        User user2 = new User();
        user2.setId(2l);
        user2.setUsername(USER);
        user2.setPassword("");
        user2.setName(new Name("test2", "test2", "test2"));
        List<Contact> contacts = Lists.newArrayList();
        contacts.add(new Contact(ContactType.HOME, "11111"));
        contacts.add(new Contact(ContactType.MOBILE, "11111"));
        user2.setContacts(contacts);
        userRepo.save(user2);
    }

    @Test
    public void testSearchUsersUsingFirstName() {
        List<User> users = userRepo.searchUsers("test1", null);
        assertEquals(1, users.size());
    }

    @Test
    public void testSearchUsersUsingLastName() {
        List<User> users = userRepo.searchUsers(null, "test2");
        assertEquals(1, users.size());
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userRepo.findAll();
        assertEquals(2, users.size());
    }

    @Test
    @Transactional(readOnly = true)
    public void testFindByUserName() {
        User user1 = userRepo.findByUsername(ADMIN);
        assertNotNull(user1);

        User user2 = userRepo.findByUsername(USER);
        assertNotNull(user2);
        assertEquals(2, user2.getContacts().size());
    }

    @Test
    public void testFindByFirstAndLastName() {
        List<User> users1 = userRepo.findAll();
        List<User> users = userRepo.findByName_FirstNameAndName_LastName("test2", "test2");
        assertFalse(users.isEmpty());
    }

}
