package de.ostfale.sb.sbreftest.user.api;

import java.util.List;

public interface UserRepo {
    
    void save(User user);
    
    User findByName(String name);
    
    List<User> findAll();

    Boolean delete(User user);
}
