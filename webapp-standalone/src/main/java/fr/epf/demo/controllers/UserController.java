package fr.epf.demo.controllers;

import fr.epf.demo.UserDAO;
import fr.epf.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String listUsers(Model m) {
        m.addAttribute("users", userDAO.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String showCreateUserPage(Model m) {
        m.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public RedirectView createUser(@ModelAttribute User user, RedirectAttributes attrs) {
        userDAO.save(user);
        attrs.addFlashAttribute("message", "Ajouté avec succès !");
        return new RedirectView("/");
    }
}
