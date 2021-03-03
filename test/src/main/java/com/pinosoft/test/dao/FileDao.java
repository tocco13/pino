package com.pinosoft.test.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.*;

public class FileDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public int fileUpload(FileVO fVO) {
		return SqlSession.insert("fSQL.fileUpload", fVO);
	}
	
	public int checkName(String orgname){
		return SqlSession.selectOne("fSQL.checkFileName", orgname);
	}
	
	public String getImage(String id){
		return SqlSession.selectOne("fSQL.getImage", id);
	}
	
	public int checkOld(String id) {
		return SqlSession.selectOne("fSQL.checkOld", id);
	}
	
	public int deleteOld(String id) {
		return SqlSession.delete("fSQL.deleteOld", id);
	}
	
	public int deleteFileRecord(String sabun) {
		return SqlSession.delete("fSQL.deleteFileRecord", sabun);
	}
}
