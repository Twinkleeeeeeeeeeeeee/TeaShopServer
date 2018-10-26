package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.DealOfPreSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DealOfPreSubmitController {
    @Autowired
    DealOfPreSubmitService dealOfPreSubmitService;
    @RequestMapping(value = "dealOfPreSubmit",method =RequestMethod.GET )
    public void setDealOfPreSubmitInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> data = new HashMap<String, Object>();
        String teaId = request.getParameter("id");
        Map<String, Object> map = dealOfPreSubmitService.DealOfPreSubmit(teaId);
        data.put("data",map);
        Object js = JSONObject.toJSON(data);
        response.getWriter().print(js);
    }
}
