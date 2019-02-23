package com.zjzx.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.dao.CompanyauthDao;

public class CompanyauthService   {
	@Autowired
	private CompanyauthDao companyauthDao;

	public JSONObject saveCompanyAuth(Record record) {
		// TODO Auto-generated method stub
		companyauthDao.saveCompanyAuth(record);
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		return resMap;
	}

}
