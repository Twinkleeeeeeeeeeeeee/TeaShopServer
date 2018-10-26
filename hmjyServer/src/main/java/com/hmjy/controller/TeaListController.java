package com.hmjy.controller;


import com.alibaba.fastjson.JSONObject;
import com.hmjy.pojo.TeaInfo;
import com.hmjy.service.GetTeaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeaListController {
    @Autowired
    private GetTeaListService teaList;

    @RequestMapping(value = "getTeaList", method = RequestMethod.GET)
    public void getTeaList(HttpServletRequest request ,HttpServletResponse response) throws IOException {
        String categoryId = request.getParameter("categoryId");
        String nameLike = request.getParameter("nameLike");
        System.out.print(nameLike);
        List<TeaInfo> tea = teaList.getTeaList(categoryId,nameLike);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("data", tea);
        map.put("message", "success");
        Object js = JSONObject.toJSON(map);
        response.setCharacterEncoding("utf8");
        response.getWriter().print(js);
    }
}
