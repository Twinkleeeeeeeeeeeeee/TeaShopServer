package com.hmjy.controller;

import com.hmjy.mapper.RegisterUserMapper;
import com.hmjy.pojo.UserInfo;
import com.hmjy.service.DecodeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("decodeUser")
public class DecodeUserController {

    @Autowired
    private DecodeUserService decodeUser;
    @Autowired
    private RegisterUserMapper registerUserMapper;
    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.GET)
    public void DecodeUserService(HttpServletRequest request, HttpServletResponse response){
       String encryptedData = request.getParameter("encryptedData");
       String iv = request.getParameter("iv");
       String code = request.getParameter("code");
       UserInfo userInfo = decodeUser.decodeUser(encryptedData,iv,code);
       registerUserMapper.add(userInfo);
       response.setContentType("text/javascript;charset=utf-8");
       response.setCharacterEncoding("utf-8");
       try
       {
            response.getWriter().print(userInfo.getOpenId());
       } catch (IOException e) {
            e.printStackTrace();
       }

    }
}
