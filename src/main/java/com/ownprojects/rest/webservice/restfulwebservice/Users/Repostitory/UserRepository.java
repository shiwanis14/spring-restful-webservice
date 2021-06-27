package com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory;

import com.ownprojects.rest.webservice.restfulwebservice.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
