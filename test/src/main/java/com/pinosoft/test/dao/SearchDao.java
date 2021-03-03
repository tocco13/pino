package com.pinosoft.test.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.*;

public class SearchDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public List<InsaVO> searchEmp (HashMap<Object, Object> map) {
		return SqlSession.selectList("iSQL.searchEmp", map);
	}
	
	public Map<Object, Object> empDetail (String sabun){
		return SqlSession.selectOne("iSQL.empDetail", sabun);
	}

	public int countList() {
		return SqlSession.selectOne("iSQL.countList");
	}
	
}
