package com.hmjy.util;


import com.alibaba.fastjson.JSONObject;
import com.hmjy.pojo.UserInfo;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DecodeUserInfo {
    private static Logger logger = Logger.getLogger(DecodeUserInfo.class);

    public Map decodeUserInfo(String encryptedData, String iv, String code) {

        Map map = new HashMap();
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("message", "code不能为空");
            return map;
        }
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
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        /*2、对encryptedData加密数据进行AES解密*/
        try {
            String result = AESCBCUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map userInfo = new HashMap();
                userInfo.put("code", userInfoJSON.get("code"));
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                logger.debug(map);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;

    }

    public UserInfo decodeUser(String encryptedData, String iv, String code) {
        JSONObject json = new WxRequest().wxResponse(code);
        String session_key = json.get("session_key").toString();
        /*2、对encryptedData加密数据进行AES解密*/
        try {
            String result = AESCBCUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {

                UserInfo userInfo = new UserInfo();
                JSONObject userInfoJSON = JSONObject.parseObject(result);
                SimpleDateFormat dd=new SimpleDateFormat("yyyyMMddhhmmss");
                String uid=dd.format(new Date());


                userInfo.setOpenId((String) userInfoJSON.get("openId"));
                userInfo.setNickName((String) userInfoJSON.get("nickName"));
                userInfo.setGender((Integer) userInfoJSON.get("gender"));
                userInfo.setCity((String) userInfoJSON.get("city"));
                userInfo.setProvince((String) userInfoJSON.get("province"));
                userInfo.setCountry((String) userInfoJSON.get("country"));
                userInfo.setAvatarUrl((String) userInfoJSON.get("avatarUrl"));
                userInfo.setUnionId((String) userInfoJSON.get("unionId"));
                userInfo.setUid(Long.parseLong(uid));

                return userInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
