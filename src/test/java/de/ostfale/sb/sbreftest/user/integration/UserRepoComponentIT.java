package de.ostfale.sb.sbreftest.user.integration;

import de.ostfale.sb.sbreftest.user.api.User;
import de.ostfale.sb.sbreftest.user.api.UserRepo;
import de.ostfale.sb.sbreftest.user.internal.UserComponentConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={UserComponentConfiguration.class})
@DisplayName( "UserRepoComponentIT")
@Tag("integrationTest")
public class UserRepoComponentIT {

    @Autowired
    UserRepo userRepo;

    @Test
    @DisplayName( "Given two users present, when findAll is called, then return list with two users")
    void testFindAllWhenUsersPresent() {
        // given
        User user1 = new User("Alice", 30, "alice@example.com");
        User user2 = new User("Bob", 25, "bob@example.com");
        userRepo.save(user1);
        userRepo.save(user2);

        // when
        List<User> users = userRepo.findAll();

        // then
        assertEquals(2, users.size(), "User list size should be 2 when there are two users present");
        assertEquals("Alice", users.get(0).name(), "First user's name should be Alice");
        assertEquals("Bob", users.get(1).name(), "Second user's name should be Bob");
    }
}
