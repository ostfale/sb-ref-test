package de.ostfale.sb.sbreftest.user.internal;

import de.ostfale.sb.sbreftest.user.api.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserRepo Inject Mock Test")
@Tag("UnitTest")
public class UserRepoInjectMockTest {

    @Mock
    private UserRepoService userRepoService;

    @BeforeEach
    void setUp() {
        Mockito.reset(userRepoService);
    }

    @Test
    @DisplayName("Given no users present, when findAll is called, then return empty list")
    void testFindAllWhenNoUsersPresent() {
        when(userRepoService.findAll()).thenReturn(Collections.emptyList());

        List<User> users = userRepoService.findAll();

        assertTrue(users.isEmpty(), "User list should be empty when no users are present");
    }

    @Test
    @DisplayName("Given two users present, when findAll is called, then return list with two users")
    void testFindAllWhenUsersPresent() {
        User user1 = new User("Alice", 30, "alice@example.com");
        User user2 = new User("Bob", 25, "bob@example.com");
        when(userRepoService.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userRepoService.findAll();

        assertEquals(2, users.size(), "User list size should be 2 when there are two users present");
        assertEquals("Alice", users.get(0).name(), "First user's name should be Alice");
        assertEquals("Bob", users.get(1).name(), "Second user's name should be Bob");
    }

    @Test
    @DisplayName("Given one user present, when delete is called, then return true")
    void testDeleteUserIfTwoUsersArePresent() {
        // given
        User user1 = new User("Alice", 30, "alice@example.com");

        // when
        userRepoService.delete(user1);

        // then
        verify(userRepoService, times(1)).delete(user1);
    }
}
