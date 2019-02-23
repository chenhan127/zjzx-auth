package com.zjzx.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.annotation.EmptyCheck;
import com.zjzx.service.CompanyauthService;
import com.zjzx.util.DateUtil;


@org.springframework.stereotype.Controller
@RequestMapping("/companyauth")
@ResponseBody
public class CompanyauthController{
	@Autowired
	private CompanyauthService companyauthService;
	/**
	 * 提交企业认证
	 */
	@RequestMapping("/submitAuth")
	@EmptyCheck({"userid"})
	public JSONObject submitAuth(Integer userid, String record){
		JSONObject recordjson = JSONObject.parseObject(record);
		Record auth = new Record();
		auth.setColumns(recordjson);
		auth.set("userid", userid);
		auth.set("authtime", DateUtil.convertY_M_D_H_M(new Date()));
		JSONObject resMap =  companyauthService.saveCompanyAuth(auth);
		return resMap;
	}

}
