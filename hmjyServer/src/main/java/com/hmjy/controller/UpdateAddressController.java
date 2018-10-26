package com.hmjy.controller;

import com.hmjy.service.CheckTokenService;
import com.hmjy.service.UpdateAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class UpdateAddressController {
    @Autowired
    private UpdateAddressService updateAddressService;
    @Autowired
    private CheckTokenService checkTokenService;
    @RequestMapping(value = "updateAddress",method = RequestMethod.GET)
    public void updateAddress(HttpServletRequest request){
        String id = request.getParameter("id");
        String token = request.getParameter("token");
        try {
            checkTokenService.checkToken(token);
            updateAddressService.updateAddress(id);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
