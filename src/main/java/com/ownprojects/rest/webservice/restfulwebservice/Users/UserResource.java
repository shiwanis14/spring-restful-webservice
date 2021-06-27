package com.ownprojects.rest.webservice.restfulwebservice.Users;

import java.io.PipedOutputStream;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory.PostRepository;
import com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory.UserDaoService;
import com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

  @Autowired
  UserDaoService service;

  @Autowired
  UserRepository repository;

  @Autowired
  PostRepository postRepository;

  @GetMapping(path = "/users")
  public List<User> getAllUsers() {
    return repository.findAll();
  }

  @PostMapping(path = "/users")
  public ResponseEntity addUser(@Valid @RequestBody User user) {
    User newUser = repository.save(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
        .buildAndExpand(newUser.getId()).toUri();
    return ResponseEntity.created(uri).build(); //give back URL use to client
  }

  @GetMapping(path = "/users/{userId}")
  public Optional<User> getAUser(@PathVariable Integer userId) {
    Optional<User> user = repository.findById(userId);

    if (!user.isPresent()) {
      throw new UserNotFoundException("id: " + userId); //link to get back and have ALL users
    }
    //hateoas
//    EntityModel<User> model = EntityModel.of(user);
//    WebMvcLinkBuilder links = linkTo(
//        methodOn(this.getClass()).getAllUsers()); //add links to all users
//    return model.add(links.withRel("all-users"));
    return user;
  }

  @DeleteMapping(path = "/users/{userId}")
  public ResponseEntity deleteAUser(@PathVariable Integer userId) {
    Optional<User> user = repository.findById(userId);
    if (!user.isPresent()) {
      throw new UserNotFoundException("id: " + userId);
    }
    repository.delete(user.get());
    return new ResponseEntity(HttpStatus.OK);
  }


  @GetMapping(path = "/users/{userId}/posts")
  public List<Post> getAUserPosts(@PathVariable Integer userId) {
    Optional<User> user = repository.findById(userId);

    if (!user.isPresent()) {
      throw new UserNotFoundException("id: " + userId);
    }
    return user.get().getPosts();
  }


  @PostMapping (path = "/users/{userId}/posts")
  public Post createPost(@PathVariable Integer userId , @RequestBody Post post) {
    Optional<User> user = repository.findById(userId);
    if (!user.isPresent()) {
      throw new UserNotFoundException("id: " + userId);
    }
    User u= user.get();
    post.setUser(u);
    postRepository.save(post);
    return post;
  }
}
