package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.GetTeaDetailService;

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
public class TeaDetailMapperController {
    @Autowired
    private GetTeaDetailService teaDetailService;
    @RequestMapping(value = "teaDetail",method = RequestMethod.GET)
    public void teaDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String teaId = request.getParameter("id");
        Map teaDetail = teaDetailService.getTeaDetail(Integer.parseInt(teaId));
        Map map = new HashMap();
        map.put("data",teaDetail);
        Object json = JSONObject.toJSON(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(json);
    }
}
