package com.pinosoft.test.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.*;

public class FileBDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public int fileUpload(FileVOB fVO) {
		return SqlSession.insert("fbSQL.bfileUpload", fVO);
	}
	
	public int checkFileName(String orgname){
		return SqlSession.selectOne("fbSQL.bcheckFileName", orgname);
	}
	
	public String getImage(String id){
		return SqlSession.selectOne("fbSQL.bgetImage", id);
	}
	
	public int bcheckOld(String id) {
		return SqlSession.selectOne("fbSQL.bcheckOld", id);
	}
	
	public int bdeleteOld(String id) {
		return SqlSession.delete("fbSQL.bdeleteOld", id);
	}
}
