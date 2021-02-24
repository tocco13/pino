package com.pinosoft.test.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.InsaVO;

public class SearchDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public List<InsaVO> searchEmp (HashMap<String, Object> map) {
		return SqlSession.selectList("iSQL.searchEmp", map);
	}
	
	public List<InsaVO> empDetail (String string){
		return SqlSession.selectList("empDetail", string);
	}
	
}
