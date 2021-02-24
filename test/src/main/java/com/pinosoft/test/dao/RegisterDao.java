package com.pinosoft.test.dao;

import java.util.List;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.pinosoft.test.vo.InsaVO;

public class RegisterDao {
	
	@Autowired
	SqlSessionTemplate SqlSession;
	
	public List<InsaVO> getEmailProvider () {
		return SqlSession.selectList("iSQL.getEmailProvider");
	}
	
	public List<InsaVO> getJobType () {
		return SqlSession.selectList("iSQL.getJobType");
	}
	
	public List<InsaVO> getJobRank(){
		return SqlSession.selectList("iSQL.getJobRank");
	}
	
	public List<InsaVO> getDept(){
		return SqlSession.selectList("iSQL.getDept");
	}
	
	public List<InsaVO> getMilType(){
		return SqlSession.selectList("iSQL.getMilType");
	}
	
	public List<InsaVO> getMilRank(){
		return SqlSession.selectList("iSQL.getMilRank");
	}
	
	public List<InsaVO> getKosaClass(){
		return SqlSession.selectList("iSQL.getKosaClass");
	}
	
	public int getId(String string) {
		return SqlSession.selectOne("iSQL.getId", string);
	}
	
	public int addEmp (InsaVO iVO) {
		return SqlSession.insert("iSQL.addEmp", iVO);
	}
	
	public int empUpdate (InsaVO iVO) {
		return SqlSession.insert("iSQL.empUpdate", iVO);
	}
	
}
