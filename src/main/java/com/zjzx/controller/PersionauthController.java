package com.zjzx.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.annotation.EmptyCheck;
import com.zjzx.service.PersionauthService;
import com.zjzx.util.DateUtil;


@org.springframework.stereotype.Controller
@RequestMapping("/persionauth")
@ResponseBody
public class PersionauthController{
	@Autowired
	private PersionauthService persionauthService;
	/**
	 * 提交个人认证
	 */
	@RequestMapping("/submitAuth")
	@EmptyCheck({"userid"})
	public JSONObject submitAuth(Integer userid, String record){
		JSONObject recordjson = JSONObject.parseObject(record);
		Record auth = new Record();
		auth.setColumns(recordjson);
		auth.set("userid", userid);
		auth.set("authtime", DateUtil.convertY_M_D_H_M(new Date()));
		JSONObject resMap =  persionauthService.submitAuth(auth);
		return resMap;
	}
	/**
	 * 判断用户是否认证
	 * @param userid
	 * @return
	 */
	@RequestMapping("/testAuth")
	public JSONObject  testAuth(Integer userid){
		JSONObject resMap = persionauthService.testAuth(userid);
		return resMap;
	}

}
