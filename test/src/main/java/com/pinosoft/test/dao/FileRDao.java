package com.pinosoft.test.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.*;

public class FileRDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public int fileUpload(FileVOR fVO) {
		return SqlSession.insert("frSQL.rfileUpload", fVO);
	}
	
	public int checkName(String orgname){
		return SqlSession.selectOne("frSQL.rcheckFileName", orgname);
	}
	
	public String getImage(String id){
		return SqlSession.selectOne("frSQL.rgetImage", id);
	}
	
	public int rcheckOld(String id) {
		return SqlSession.selectOne("frSQL.rcheckOld", id);
	}
	
	public int rdeleteOld(String id) {
		return SqlSession.delete("frSQL.rdeleteOld", id);
	}
}
