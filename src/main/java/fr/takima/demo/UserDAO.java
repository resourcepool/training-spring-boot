package fr.takima.demo;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
@Repository
public class UserDAO {
  private List<User> users = new ArrayList<>();

  public void add(User u) {
    users.add(u);
  }

  public List<User> findAll() {
    return Collections.unmodifiableList(users);
  }


  @PostConstruct
  public void initDb() {
    users.add(new User("Loïc", "Ortola", 29));
    users.add(new User("Thibault", "Roussin", 22));
    users.add(new User("Nadia", "Comptier", null));
  }
}
