package org.launchcode.mybestfriend.controllers;

import org.launchcode.mybestfriend.models.Journal;
import org.launchcode.mybestfriend.models.User;
import org.launchcode.mybestfriend.models.data.JournalDao;
import org.launchcode.mybestfriend.models.data.PetDao;
import org.launchcode.mybestfriend.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected PetDao petDao;

    @Autowired
    protected JournalDao journalDao;


    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session){

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session,User user){
        session.setAttribute(userSessionKey, user.getUid());
    }
    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request){
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}
