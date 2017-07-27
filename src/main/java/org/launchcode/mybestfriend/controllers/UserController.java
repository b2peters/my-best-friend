package org.launchcode.mybestfriend.controllers;

import org.launchcode.mybestfriend.models.data.UserDao;
import org.launchcode.mybestfriend.models.forms.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    protected UserDao userDao;

    @RequestMapping(value="sign-up", method = RequestMethod.GET)
    public String signUpForm(Model model){
        model.addAttribute(new SignUpForm());
        model.addAttribute("title", "Welcome");

        return "user/sign-up";}
}
