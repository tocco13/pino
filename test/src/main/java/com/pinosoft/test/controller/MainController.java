package com.pinosoft.test.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinosoft.test.dao.*;
import com.pinosoft.test.vo.*;

@Controller
public class MainController {

	@Autowired
	RegisterDao rDao;

	@Autowired
	SearchDao sDao;

	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public ModelAndView main(ModelAndView mv) {

		mv.setViewName("main/main");
		return mv;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam(value="id", required=false) String id) {
		int cnt = 0;

		cnt = rDao.getId(id);
		
		return cnt; 
	}
	
	@RequestMapping(value = "/register/register", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView register(ModelAndView mv) {

		List<InsaVO> eplist = rDao.getEmailProvider();
		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();
		List<InsaVO> dept = rDao.getDept();
		List<InsaVO> miltype = rDao.getMilType();
		List<InsaVO> milrank = rDao.getMilRank();
		List<InsaVO> kosaclass = rDao.getKosaClass();

		mv.addObject("eplist", eplist);
		mv.addObject("jobtype", jobtype);
		mv.addObject("jobrank", jobrank);
		mv.addObject("dept", dept);
		mv.addObject("miltype", miltype);
		mv.addObject("milrank", milrank);
		mv.addObject("kosaclass", kosaclass);

		mv.setViewName("register/register");
		return mv;
	}

	@RequestMapping(value = "/register/registerproc", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ModelAndView registerproc(ModelAndView mv, HttpServletResponse response, @RequestParam Map<Object, Object> allParams) throws IOException {
		//마지막 수정 - responsebody, httpservletresponse, printwriter
		int cnt = 0;
		InsaVO iVO = new InsaVO();

        iVO.setName(allParams.get("name").toString());
        iVO.setHp(allParams.get("hp").toString());
        iVO.setId(allParams.get("id").toString());
        iVO.setPwd(allParams.get("pwd").toString());
        iVO.setEmail(allParams.get("email").toString());
        iVO.setName(allParams.get("name").toString());
        iVO.setEng_name(allParams.get("eng_name").toString());
        iVO.setPhone(allParams.get("phone").toString());
        iVO.setReg_no(allParams.get("reg_no").toString());
        if(allParams.get("years") == null || allParams.get("years").equals("")) {
        	iVO.setYears(0);
        } else {
        iVO.setYears(Integer.parseInt(allParams.get("years").toString()));
        }
        iVO.setJob_type(allParams.get("job_type").toString());
        iVO.setSex(allParams.get("sex").toString());
        if(allParams.get("zip") == null || allParams.get("zip").equals("")) {
        	iVO.setZip(0);
        } else {
        iVO.setZip(Integer.parseInt(allParams.get("zip").toString()));
        }
        iVO.setAddr1(allParams.get("addr1").toString());
        iVO.setAddr2(allParams.get("addr2").toString());
        iVO.setPos_gbn_code(allParams.get("pos_gbn_code").toString());
        iVO.setDept_code(allParams.get("dept_code").toString());
        if(allParams.get("salary") == null || allParams.get("salary").equals("")) {
        	iVO.setSalary(0);
        } else {
        iVO.setSalary(Integer.parseInt((allParams.get("salary").toString())));
        }
        iVO.setCurrent_yn(allParams.get("current_yn").toString());
        iVO.setGart_level(allParams.get("gart_level").toString());
        iVO.setPut_yn(allParams.get("put_yn").toString());
        iVO.setMil_yn(allParams.get("mil_yn").toString());
        if(allParams.get("mil_yn").toString().equals("Y")) {
        	iVO.setMil_type(allParams.get("mil_type").toString());
        	iVO.setMil_level(allParams.get("mil_level").toString());
        	iVO.setMil_startdate(allParams.get("mil_startdate").toString());
        	iVO.setMil_enddate(allParams.get("mil_enddate").toString());
        }
        iVO.setKosa_reg_yn(allParams.get("kosa_reg_yn").toString());
        if(allParams.get("kosa_reg_yn").toString().equals("Y")) {
        	iVO.setKosa_class_code(allParams.get("kosa_class_code").toString());
        }
        iVO.setJoin_day(allParams.get("join_day").toString());
        iVO.setRetire_day(allParams.get("retire_day").toString());
        iVO.setCmp_reg_no(allParams.get("cmp_reg_no").toString());
        iVO.setCrm_name(allParams.get("crm_name").toString());
        iVO.setSelf_intro(allParams.get("self_intro").toString());
       
		cnt = rDao.addEmp(iVO);
		if (cnt == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('등록이 완료되었습니다'); location.href='/register/register.pino'; </script>");
			out.flush();
			//mv.setViewName("redirect:/register/register.pino");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('등록 중 오류가 발생했습니다'); location.href='/register/register.pino';</script>");
			out.flush();
			//mv.setViewName("redirect:/main/main.pino");
		}

		return mv;
	}
	
	@RequestMapping(value = "/search/search", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView search(ModelAndView mv) {

		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();

		mv.addObject("jobtype", jobtype);
		mv.addObject("jobrank", jobrank);
		mv.setViewName("search/search");
		return mv;
	}

	@RequestMapping(value = "/search/search2", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView search2(ModelAndView mv,
			@RequestParam(value = "empsabun", required = false) Integer sabun,
			@RequestParam(value = "empkrname", required = false) String name,
			@RequestParam(value = "nameparam", required=false) String name2,
			@RequestParam(value="sabunparam", required=false) String sabunparam,
			@RequestParam(value = "empstate", required = false) String join_yn,
			@RequestParam(value = "insertstate", required = false) String put_yn,
			@RequestParam(value = "emprank", required = false) String job_rank,
			@RequestParam(value = "join_day", required = false) String join_day,
			@RequestParam(value = "retire_day", required = false) String retire_day,
			@RequestParam(value = "job_type", required = false) String job_type,
			PageVO pVO, 
			@RequestParam(value="nowPage", required=false) String nowPage, 
			@RequestParam(value="cntPerPage", required=false) String cntPerPage
			) {
		
		//게시글 총 갯수 구하고
		int total = sDao.countList();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		
		pVO = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		
//	 Iterator<String> mapIter = page.keySet().iterator();
//	 
//        while(mapIter.hasNext()){
// 
//            String key = mapIter.next();
//            Object value = page.get(key);
// 
//            System.out.println(key+" : "+value);
// 
//        }
		
		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();

		HashMap<Object, Object> map = new HashMap<Object, Object>();
		if(sabun != null) {
		map.put("sabun", sabun);
		} else if (sabunparam != null) {
			map.put("sabun", sabunparam);
		}
		if(name != null) {
		map.put("name", name);
		} else if (name2 != null) {
		map.put("name", name2);
		}
		map.put("current_yn", join_yn); 
		map.put("put_yn", put_yn); 
		map.put("pos_gbn_code",job_rank);
		map.put("join_day", join_day); 
		map.put("retire_day", retire_day);
		map.put("job_type", job_type);
		map.put("start", pVO.getStart());
		map.put("end", pVO.getEnd());
//		map.putAll(page);
				 
		List<InsaVO> result = sDao.searchEmp(map);
		
		mv.addObject("paging", pVO);
		mv.addObject("list", result);
		mv.addObject("jobtype", jobtype);
		mv.addObject("jobrank", jobrank);
		mv.setViewName("search/search2");
		return mv;
	}



	@RequestMapping(value = "/edit/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView edit(ModelAndView mv, HttpServletRequest req, @RequestParam(value="sabunparam", required=false)String sabun) {
		
		//		HashMap<String, Object> list = sDao.empDetail(sabun);
		Map<Object, Object> list = sDao.empDetail(sabun);
//		Iterator<Object> mapIter = list.keySet().iterator();
//				
//				while(mapIter.hasNext()){
//					
//					Object key = mapIter.next();
//					Object value = list.get(key);
//					
//					System.out.println(key+" : "+value);	
//		}
//		System.out.println("---에딧 조회값 끝---");
		
//		list.put("sabun", list.get("sabun"));
//		list.put("profile", list.get("profile"));
		
//		Set<Entry<String, Object>> entryset = list.entrySet();
//		ArrayList<Entry<String, Object>> entrylist = new ArrayList<Entry<String, Object>> (entryset);
//		System.out.println(entrylist);
		
		List<InsaVO> eplist = rDao.getEmailProvider();
		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();
		List<InsaVO> dept = rDao.getDept();
		List<InsaVO> miltype = rDao.getMilType();
		List<InsaVO> milrank = rDao.getMilRank();
		List<InsaVO> kosaclass = rDao.getKosaClass();
		
		mv.addObject("list", list);
//		mv.addObject("map", list);
//		mv.addObject("list", entrylist);
		mv.addObject("eplist", eplist);
		mv.addObject("jobtype", jobtype);
		mv.addObject("jobrank", jobrank);
		mv.addObject("dept", dept);
		mv.addObject("miltype", miltype);
		mv.addObject("milrank", milrank);
		mv.addObject("kosaclass", kosaclass);
		mv.setViewName("edit/edit");
		return mv;
	}
	
	@RequestMapping(value="/edit/editproc", method=RequestMethod.POST)
	public ModelAndView editProc(ModelAndView mv, @RequestParam Map<Object, Object> allParams, RedirectAttributes red) throws IOException {
		String change = "";
		int cnt = 0;
		InsaVO iVO = new InsaVO();
//		Iterator<Object> keys = allParams.keySet().iterator();
//        while( keys.hasNext() ){
//            Object key = keys.next();
//            System.out.println( String.format("키 : %s, 값 : %s", key, allParams.get(key)) );
//        }
//        System.out.println("---수정값 종료---");
//        int변수는 공백일경우 0처리 하도록 if문 넣을것
        change = allParams.get("sabun").toString().replace(" ","");
        iVO.setSabun(Integer.parseInt(change));
        iVO.setName(allParams.get("name").toString());
        iVO.setHp(allParams.get("hp").toString());
        iVO.setId(allParams.get("id").toString());
        iVO.setPwd(allParams.get("pwd").toString());
        iVO.setEmail(allParams.get("email").toString());
        iVO.setName(allParams.get("name").toString());
        iVO.setEng_name(allParams.get("eng_name").toString());
        iVO.setPhone(allParams.get("phone").toString());
        iVO.setReg_no(allParams.get("reg_no").toString());
        if(allParams.get("years") == null || allParams.get("years").equals("")) {
        	iVO.setYears(0);
        } else {
        iVO.setYears(Integer.parseInt(allParams.get("years").toString()));
        }
        iVO.setJob_type(allParams.get("job_type").toString());
        iVO.setSex(allParams.get("sex").toString());
        if(allParams.get("zip") == null || allParams.get("zip").equals("")) {
        	iVO.setZip(0);
        } else {
        iVO.setZip(Integer.parseInt(allParams.get("zip").toString()));
        }
        iVO.setAddr1(allParams.get("addr1").toString());
        iVO.setAddr2(allParams.get("addr2").toString());
        iVO.setPos_gbn_code(allParams.get("pos_gbn_code").toString());
        iVO.setDept_code(allParams.get("dept_code").toString());
        if(allParams.get("salary") == null || allParams.get("salary").equals("")) {
        	iVO.setSalary(0);
        } else {
        iVO.setSalary(Integer.parseInt((allParams.get("salary").toString())));
        }
        iVO.setCurrent_yn(allParams.get("current_yn").toString());
        iVO.setGart_level(allParams.get("gart_level").toString());
        iVO.setPut_yn(allParams.get("put_yn").toString());
        iVO.setMil_yn(allParams.get("mil_yn").toString());
        if(allParams.get("mil_yn").toString().equals("Y")) {
        	iVO.setMil_type(allParams.get("mil_type").toString());
        	iVO.setMil_level(allParams.get("mil_level").toString());
        	iVO.setMil_startdate(allParams.get("mil_startdate").toString());
        	iVO.setMil_enddate(allParams.get("mil_enddate").toString());
        }
        iVO.setKosa_reg_yn(allParams.get("kosa_reg_yn").toString());
        if(allParams.get("kosa_reg_yn").toString().equals("Y")) {
        	iVO.setKosa_class_code(allParams.get("kosa_class_code").toString());
        }
        iVO.setJoin_day(allParams.get("join_day").toString());
        iVO.setRetire_day(allParams.get("retire_day").toString());
        iVO.setCmp_reg_no(allParams.get("cmp_reg_no").toString());
        iVO.setCrm_name(allParams.get("crm_name").toString());
        if(allParams.get("self_intro") == null) {
        	iVO.setSelf_intro("null");
        } else {
        	iVO.setSelf_intro(allParams.get("self_intro").toString());
        }
		cnt = rDao.empUpdate(iVO);
		if(cnt !=0) {
			red.addAttribute("sabunparam", iVO.getSabun());
			mv.setViewName("redirect:/search/search2.pino");
		} else {
			red.addAttribute("sabunparam", iVO.getSabun());
			mv.setViewName("edit/edit.pino");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/edit/deleteProc", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteProc(ModelAndView mv, @RequestParam(value="sabun", required=true)String sabun) {
	
		int cnt = 0;
		//delete query는 삭제된 행수를 반환한다
		cnt = rDao.empDelete(sabun);
		
		if(cnt == 1 ) {
			mv.setViewName("redirect:/search/search.pino");
		} else {
			
		}
		return mv;
	}

}
