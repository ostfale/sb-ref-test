package de.ostfale.sb.sbreftest.user.internal;

import de.ostfale.sb.sbreftest.user.api.User;
import de.ostfale.sb.sbreftest.user.api.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserRepoService Test")
@Tag("UnitTest")
class UserRepoServiceTest {

    private UserRepo userRepoService;
    private User testUser;

    @BeforeEach
    void setUp() {
        userRepoService = new UserRepoService();
        testUser = new User("John Doe", 30, "john@example.com");
        userRepoService.save(testUser);
    }

    @Test
    @DisplayName("Find existing user by name")
    void testFindByName_existingUser() {
        // given
        var expectedUser = testUser;

        // when
        User foundUser = userRepoService.findByName("John Doe");

        // then
        assertAll("Check all user values set",
                () -> assertEquals(expectedUser.name(), foundUser.name()),
                () -> assertEquals(expectedUser.email(), foundUser.email()),
                () -> assertEquals(expectedUser.age(), foundUser.age())
        );
    }

    @Test
    @DisplayName("Find non-existing user by name")
    void testFindByName_nonExistingUser() {
        // when
        User foundUser = userRepoService.findByName("Jane Doe");

        // then
        assertNull(foundUser);
    }

    @Test
    @DisplayName("Delete user from repo")
    void testDelete() {
        // when
        var result =userRepoService.delete(testUser);

        // then
        assertNull(userRepoService.findByName("John Doe"));
        assertEquals(0, userRepoService.findAll().size());
        assertTrue(result);
    }

    @Test
    @DisplayName("Find all users")
    void testFindAll() {
        // given
        var expectedUser = testUser;

        // when
        var users = userRepoService.findAll();

        // then
        assertEquals(1, users.size());
        assertEquals(expectedUser.name(), users.getFirst().name());
        assertEquals(expectedUser.email(), users.getFirst().email());
        assertEquals(expectedUser.age(), users.getFirst().age());
    }
}
