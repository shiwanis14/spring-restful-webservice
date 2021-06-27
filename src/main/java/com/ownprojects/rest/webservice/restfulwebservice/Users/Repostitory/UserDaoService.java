package com.ownprojects.rest.webservice.restfulwebservice.Users.Repostitory;

import java.util.List;
import com.ownprojects.rest.webservice.restfulwebservice.Users.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoService {

/*  private static List<User> users = new ArrayList<>();
  private static int userCount = 3;

  static{
    users.add(new User(1,"A",new Date()));
    users.add(new User(2,"B",new Date()));
    users.add(new User(3,"C",new Date()));
  }*/

  @PersistenceContext
  private EntityManager entityManager;

//  public List<User> findAll() {
//    return users;
//  }

  public User save(User user) {
    entityManager.persist(user);
    return user;
  }

//  public User findUser(int id) {
//    for (User u : users) {
//      if (u.getId() == id) {
//        return u;
//      }
//    }
//    return null;
//  }
//
//  public void deleteUser(int id) {
//    for (User u : users) {
//      if (u.getId() == id) {
//        users.remove(u);
//      }
//    }
//  }
}
