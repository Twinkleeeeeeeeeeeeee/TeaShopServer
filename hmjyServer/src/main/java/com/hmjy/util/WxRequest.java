package com.hmjy.util;

import com.alibaba.fastjson.JSONObject;

public class WxRequest {
    public static JSONObject wxResponse(String code) {
        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = WxConfig.wxspAppid;
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = WxConfig.wxspSecret;
        //授权（必填）
        String grant_type = WxConfig.grant_type;
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容(转化为json对象)
        JSONObject json = JSONObject.parseObject(sr);
        //获取会话密钥

        return json;
    }



}
