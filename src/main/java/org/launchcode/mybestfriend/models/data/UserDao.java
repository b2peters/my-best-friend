package org.launchcode.mybestfriend.models.data;

import org.launchcode.mybestfriend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
