package com.example.controller;

import javax.validation.Valid;

import com.example.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

/*    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
*/
/*@GetMapping(path = "/login")
@ResponseBody
public ModelAndView login() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
}*/


    //TODO: a login without modelandview, something like this
    //TODO: (directly login in without http input, through the parameters)
    @GetMapping(path = "/login")
    @ResponseBody
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    // /GET /user/{id} -- # Gives info about the user
    @GetMapping(path = "/get")
    public @ResponseBody
    User getUser(@RequestParam int id) {
        return userService.findUserById(id);
    }

    // POST /user/ -- # Creates a new user
    @PostMapping(value = "/post")
    public String addNewUser(@RequestParam String email,
                             @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.saveUser(user);
        return "Saved";
    }

    // DELETE /user/{id} -- # Removes a user
    @DeleteMapping(path = "/delete")
    public @ResponseBody
    void deleteUser(@RequestParam int id) {
        userService.deleteUserById(id);
    }

    //OTHER USEFUL LINKS

    @GetMapping(value = "/getAll")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }
    

}
/*
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }



*/