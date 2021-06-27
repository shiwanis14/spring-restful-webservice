package com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory;

import com.ownprojects.rest.webservice.restfulwebservice.Users.Post;
import com.ownprojects.rest.webservice.restfulwebservice.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {

}
