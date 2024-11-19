package de.ostfale.sb.sbreftest.user.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Test")
@Tag("UnitTest")
class UserTest {

    @Test
    @DisplayName("Given user values, when User is instantiated, then values should be as expected")
    void testUserCreation() {
        // given
        var name = "Martinez";
        var age = 25;
        var email = "martinez@example.com";

        // when
        User user = new User(name, age, email);

        // then
        assertNotNull(user);
        assertAll("Check all user values set",
                () -> assertEquals(name, user.name(), "Name is not set"),
                () -> assertEquals(age, user.age(), "Age ist not set"),
                () -> assertEquals(email, user.email(), "Email ist not set")
        );
    }
}
