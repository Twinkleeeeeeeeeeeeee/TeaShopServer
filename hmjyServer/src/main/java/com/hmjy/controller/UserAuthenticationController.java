package com.hmjy.controller;


import com.hmjy.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserAuthenticationController {
    @Autowired
    private UserAuthenticationService UserAuthentication;


    @RequestMapping(value = "/UserAuthentication", method = RequestMethod.GET)
    public void UserAuthenticationController(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String code = request.getParameter("code");
        Object data = UserAuthentication.UserAuthentication(code);
        response.setContentType("text/javascript;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(data);
    }
}
