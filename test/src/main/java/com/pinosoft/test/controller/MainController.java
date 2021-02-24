package com.pinosoft.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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
			@RequestParam(value = "empstate", required = false) String join_yn,
			@RequestParam(value = "insertstate", required = false) String put_yn,
			@RequestParam(value = "emprank", required = false) String job_rank,
			@RequestParam(value = "join_day", required = false) String join_day,
			@RequestParam(value = "retire_day", required = false) String retire_day,
			@RequestParam(value = "job_type", required = false) String job_type) {

		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sabun", sabun);
		if(name != null) {
		map.put("name", name);
		} else if (name2 != null) {
		map.put("name", name2);
		}
		map.put("join_yn", join_yn); 
		map.put("put_yn", put_yn); 
		map.put("job_rank",job_rank);
		map.put("put_yn", put_yn);
		map.put("join_day", join_day); 
		map.put("retire_day", retire_day);
		map.put("job_type", job_type);
		 

		List<InsaVO> result = sDao.searchEmp(map);

		mv.addObject("list", result);
		mv.addObject("jobtype", jobtype);
		mv.addObject("jobrank", jobrank);
		mv.setViewName("search/search2");
		return mv;
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

	@RequestMapping(value = "/register/registerproc", method = RequestMethod.POST)
	public ModelAndView registerproc(ModelAndView mv, InsaVO iVO) {
		
		int cnt = 0;
		cnt = rDao.addEmp(iVO);
		if (cnt == 1) {
			mv.setViewName("redirect:/register/register.pino");
		} else {
			mv.setViewName("redirect:/main/main.pino");
		}

		return mv;
	}

	@RequestMapping(value = "/edit/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView edit(ModelAndView mv, HttpServletRequest req, @RequestParam(value="nameparam", required=false)String name) {

		System.out.println(name);
		
		List<InsaVO> list = sDao.empDetail(name);
		
		List<InsaVO> eplist = rDao.getEmailProvider();
		List<InsaVO> jobtype = rDao.getJobType();
		List<InsaVO> jobrank = rDao.getJobRank();
		List<InsaVO> dept = rDao.getDept();
		List<InsaVO> miltype = rDao.getMilType();
		List<InsaVO> milrank = rDao.getMilRank();
		List<InsaVO> kosaclass = rDao.getKosaClass();

		mv.addObject("list", list);
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
	public ModelAndView editProc(ModelAndView mv, InsaVO iVO, RedirectAttributes red) {
		
		String name = iVO.getName();
		System.out.println(name);
		int tmp = rDao.empUpdate(iVO);
		
		if(tmp !=0) {
			red.addAttribute("nameparam", name);
			mv.setViewName("redirect:/search/search2.pino");
		} else {
			red.addAttribute("nameparam", name);
			mv.setViewName("/edit/edit.pino");
		}
		
		return mv;
	}
}
