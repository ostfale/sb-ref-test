package de.ostfale.sb.sbreftest.user.internal;

import de.ostfale.sb.sbreftest.user.api.User;
import de.ostfale.sb.sbreftest.user.api.UserRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("UserRepo Mock Test")
@Tag( "IntegrationTest")
class UserRepoMockTest {

    @Test
    @DisplayName( "Given no users present, when findAll is called, then return empty list")
    void testFindAllWhenNoUsersPresent() {
        UserRepo userRepo = mock(UserRepo.class);
        when(userRepo.findAll()).thenReturn(Collections.emptyList());

        List<User> users = userRepo.findAll();

        assertTrue(users.isEmpty(), "User list should be empty when no users are present");
    }

    @Test
    @DisplayName( "Given two users present, when findAll is called, then return list with two users")
    void testFindAllWhenUsersPresent() {
        UserRepo userRepo = mock(UserRepo.class);
        User user1 = new User("Alice", 30, "alice@example.com");
        User user2 = new User("Bob", 25, "bob@example.com");
        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userRepo.findAll();

        assertEquals(2, users.size(), "User list size should be 2 when there are two users present");
        assertEquals("Alice", users.get(0).name(), "First user's name should be Alice");
        assertEquals("Bob", users.get(1).name(), "Second user's name should be Bob");
    }

    @Test
    @DisplayName( "Given one user present, when delete is called, then return true")
    void testDeleteUserIfTwoUsersArePresent() {
        // given
        UserRepo userRepo = mock(UserRepo.class);
        User user1 = new User("Alice", 30, "alice@example.com");
        User user2 = new User("Bob", 25, "bob@example.com");
        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        // when
        var result = userRepo.delete(user1);

        // then
        verify(userRepo, times(1)).delete(user1);
    }
}
