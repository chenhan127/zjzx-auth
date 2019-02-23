package com.zjzx.dao;

import org.springframework.stereotype.Repository;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
@Repository
public class PersionauthDao {
	private static final String tableName = "persionauth";
	public void submitAuth(Record record) {
		// TODO Auto-generated method stub
		Db.save(tableName, record);
	}
	public Record getPersionAuthorById(Integer userid) {
		// TODO Auto-generated method stub
		String sql = "select * from "+tableName+" where userid=?";
		Record record = Db.findFirst(sql, userid);
		return record;
	}
	
	

}
