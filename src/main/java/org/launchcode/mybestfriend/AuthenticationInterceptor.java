package org.launchcode.mybestfriend;

import org.launchcode.mybestfriend.controllers.AbstractController;
import org.launchcode.mybestfriend.models.User;
import org.launchcode.mybestfriend.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws IOException {
        List<String> nonAuthPages = Arrays.asList("user/login", "user/Sign-up");

        if (!nonAuthPages.contains(request.getRequestURI())) {

            boolean isLoggedIn = false;
            User user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                user = userDao.findOne(userId);

                if (user != null)
                    isLoggedIn = true;
            }

            if (!isLoggedIn) {
                response.sendRedirect("/user/login");
                return false;
            }
        }
        return true;
    }

    }


