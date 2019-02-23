package com.zjzx.dao;

import org.springframework.stereotype.Repository;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
@Repository
public class CompanyauthDao {
	private static final String tableName = "companyauth";
	/**
	 * 保存企业认证
	 * @param record
	 */
	public void saveCompanyAuth(Record record){
		Db.save(tableName, record);
	}
	public Record getPersionAuthorById(Integer userid) {
		String sql = "select * from "+tableName+" where userid=?";
		Record record = Db.findFirst(sql, userid);
		return record;
	}

}
