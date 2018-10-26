package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.pojo.UserOrder;
import com.hmjy.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CreateOrderController {
    @Autowired
    private CreateOrderService createOrderService;

    @RequestMapping(value = "createOrder", method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(HttpServletResponse response, @RequestParam(value = "uid") String uid,
                            @RequestParam(value = "provinceId") String provinceId,
                            @RequestParam(value = "cityId") String cityId,
                            @RequestParam(value = "districtId") String districtId,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "linkMan") String linkMan,
                            @RequestParam(value = "mobile") String mobile,
                            @RequestParam(value = "code") String code,
                            @RequestParam(value = "allGoodsPrice") String allGoodsPrice) throws IOException {
        UserOrder userOrder = new UserOrder();
        Map<String, Object> map = new HashMap<>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderId = dateFormat.format(date);
        try {
            //JSONObject.parseObject(postData);
            userOrder.setUserId(uid);
            userOrder.setOrderId(orderId);
            userOrder.setProvinceId(provinceId);
            userOrder.setCityId(cityId);
            if(!districtId.equals("")){
                userOrder.setDistrictId(districtId);
            }
            userOrder.setAddress(address);
            userOrder.setLinkMan(linkMan);
            userOrder.setMobile(mobile);
            userOrder.setCode(code);
            userOrder.setDateAdd(formatter.format(date));
            userOrder.setAllGoodsPrice(Float.parseFloat(allGoodsPrice));

            createOrderService.createOrder(userOrder);
            map.put("code", 0);
        } catch (Exception e) {
            map.put("code", 500);
            e.printStackTrace();
        }
        response.getWriter().print(JSONObject.toJSON(map));
    }
}
