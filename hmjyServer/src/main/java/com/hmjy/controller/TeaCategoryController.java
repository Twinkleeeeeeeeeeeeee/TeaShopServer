package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.pojo.TeaCategory;
import com.hmjy.service.GetTeaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TeaCategoryController {
    @Autowired
    private GetTeaCategoryService teaCategoryService;
    @RequestMapping(value = "getTeaCategory",method = RequestMethod.GET)
    public void getTeaCategory(HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap();
        List<TeaCategory> teaCategory = teaCategoryService.getTeaCategoryService();
        map.put("code",0);
        map.put("data",teaCategory);
        Object json = JSONObject.toJSON(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(json);
    }
}
