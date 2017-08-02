package org.launchcode.mybestfriend.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.mybestfriend.models.User;
import org.launchcode.mybestfriend.models.data.UserDao;
import org.launchcode.mybestfriend.models.forms.LogInForm;
import org.launchcode.mybestfriend.models.forms.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController extends AbstractController{


    @RequestMapping(value="/sign-up", method = RequestMethod.GET)
    public String signUpForm(Model model){
        model.addAttribute(new SignUpForm());
        model.addAttribute("title", "Welcome");

        return "user/sign-up";
    }

    @RequestMapping(value="/sign-up", method=RequestMethod.POST)
    public String signUp(@ModelAttribute @Valid SignUpForm form, Errors errors, HttpServletRequest request){
        if (errors.hasErrors()){
            return "user/sign-up";
        }

        User existingUser = userDao.findByUsername(form.getUsername());

        if(existingUser != null){
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "user/sign-up";
        }
        User newUser = new User(form.getUsername(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:/";
    }
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(Model model){
        model.addAttribute(new LogInForm());
        model.addAttribute("title", "Log In");
        return"user/login";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(Model model, @ModelAttribute @Valid LogInForm form, Errors errors, HttpServletRequest request){
        if (errors.hasErrors()){
            return "user/login";
        }


        if(userDao.findByUsername(form.getUsername()) == null){

            errors.rejectValue("username", "unknown.user", "Unknown user");
            return "user/login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if(!theUser.isMatchingPassword(password)){

            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "user/login";
        }
        setUserInSession(request.getSession(), theUser);
        return "redirect:/";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/user/login";
    }



    @RequestMapping(value="")
    public String index(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());


        model.addAttribute("title", "My Pets");
        model.addAttribute("pets", petDao.findByOwner(user));
        return "/user/index";

    }
}
