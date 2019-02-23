package com.zjzx.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.dao.CompanyauthDao;
import com.zjzx.dao.PersionauthDao;

public class PersionauthService  {
	@Autowired
	private PersionauthDao persionauthDao;
	@Autowired
	private CompanyauthDao companyauthDao;
	
	public JSONObject submitAuth(Record record) {
		// TODO Auto-generated method stub
		record.set("state", 0);
		persionauthDao.submitAuth(record);
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		return resMap;
	}

	public JSONObject testAuth(Integer userid) {
		// TODO Auto-generated method stub
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		Record  record = persionauthDao.getPersionAuthorById(userid);
		if(record != null){
			resMap.put("isauth", "1");
			return resMap;
		}
		
		record = companyauthDao.getPersionAuthorById(userid);
		if(record != null){
			resMap.put("isauth", "1");
			return resMap;
		}
		resMap.put("isauth", "0");
		return resMap;
	}

}
