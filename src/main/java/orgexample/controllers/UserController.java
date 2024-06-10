package orgexample.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import orgexample.model.User;
import orgexample.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String usersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("editUser", new User());
        return "users/users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/users";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("editUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/users";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }


//    @PostMapping("/edit")
//    public String editUser(@RequestParam("id") int id,
//                           @RequestParam("firstName") String firstName,
//                           @RequestParam("lastName") String lastName,
//                           @RequestParam("email") String email) {
//        System.out.println("Щас будем обновлять Юзера " + firstName);
//        userDAO.updateUser(new User(id, firstName, lastName, email));
//        return "redirect:/users";
//    }
}
