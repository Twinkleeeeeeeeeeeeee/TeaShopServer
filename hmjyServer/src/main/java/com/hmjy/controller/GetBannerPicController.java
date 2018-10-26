package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.pojo.BannerPic;
import com.hmjy.service.GetBannerPicService;
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
public class GetBannerPicController {
    @Autowired
    private GetBannerPicService bannerPicService;
    @RequestMapping(value = "bannerList",method = RequestMethod.GET)
    public void bannerList(HttpServletResponse response) throws IOException {
        List<BannerPic> bannerPic = bannerPicService.getBannerPic();
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("data",bannerPic);
        map.put("msg","suceess");
        Object json = JSONObject.toJSON(map);
        response.getWriter().print(json);
    }
}
