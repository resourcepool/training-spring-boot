package fr.takima.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@RequestMapping("/library")
@Controller
public class LibraryController {

  private final UserDAO userDAO;

  public LibraryController(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @GetMapping("/list")
  public String homePage(Model m) {
    m.addAttribute("users", userDAO.findAll());
    return "index";
  }

}
