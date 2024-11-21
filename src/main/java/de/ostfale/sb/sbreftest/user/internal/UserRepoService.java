package de.ostfale.sb.sbreftest.user.internal;

import de.ostfale.sb.sbreftest.user.api.User;
import de.ostfale.sb.sbreftest.user.api.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class UserRepoService implements UserRepo {

    private static final Logger log = LoggerFactory.getLogger(UserRepoService.class);

    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        log.debug("Saving user: {}", user);
        users.add(user);
    }

    @Override
    public User findByName(String name) {
        log.debug("Finding user by name: {}", name);
        for (User user : users) {
            if (user.name().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        log.debug("Finding all users");
        return new ArrayList<>(users);
    }

    @Override
    public Boolean delete(User user) {
        log.debug("Deleting user: {}", user);
        return users.remove(user);
    }
}

