package com.pinosoft.test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pinosoft.test.dao.*;
import com.pinosoft.test.vo.*;

@Controller
public class FileControllerR {
	//이력서 업로드 처리 컨트롤
	
	@Autowired
	FileRDao fDao;
	
	@Autowired
	private ServletContext sc;
	
	@RequestMapping(value="/uploadr", method={ RequestMethod.GET, RequestMethod.POST })
	public void uploadr ( @RequestParam("resume") MultipartFile upload, @RequestParam("id") String id){
		
		if(upload != null && id != null && id !="") {
			FileVOR fVO = new FileVOR();
			//1.파일명을 . 기준으로 분리
			//1-1.파일 원본명을 받고
			String orgName = upload.getOriginalFilename();
			
			//파일명이 null아닐때만 동작하게
			if(orgName != null || orgName !="") {
				
					//1-2.원본 이름 세팅해주고
					fVO.setRorg_name(orgName);
					//1-3.확장자 뗀 파일명 받고
					String fileName = "";
					try {
					fileName = orgName.substring(0, orgName.indexOf('.'));
					} catch (Exception e) {
						System.out.println("기존파일이 유지됩니다.");
					}
					//System.out.println("확장자 앞 파일이름 : " + fileName);
					
					//2.같은 파일명이 있는지 검사
					//같은 아이디로 올라온게 있는지 검사
							int cnt2 = fDao.rcheckOld(id);
							if(cnt2 == 1) {
								//기존에 올린게 있으면 삭제
								fDao.rdeleteOld(id);
							}
					//2-1.파일명 세팅하고
					fVO.setRfile_name(fileName);
					//2-2.변수에 저장
					String temp = fVO.getRfile_name();
					//2-3.변수 초기화
					int cnt = fDao.checkName(temp);
					//2-5.같은 파일명이 있으면 이름을 새로 생성해서 세팅한다
					if(cnt != 0) {
						fVO.setRfile_name(temp+UUID.randomUUID().toString().replace("-", ""));
					}
					String fileExt = orgName.substring(orgName.indexOf('.'));
					//System.out.println(". 뒤 파일이름 : "+ fileExt);
					//확장자명을 filetype에 저장
					fVO.setRfile_type(fileExt);
					//새로 조합된 savename 생성
					String savename = fVO.getRfile_name() + fVO.getRfile_type();
					fVO.setRsave_name(savename);
					
					//파일 경로 세팅
					String path = sc.getRealPath("\\")+"\\resources\\images\\resume\\";
			//		String path = "C:/Users/chris/Documents/uploads/"+fVO.getSave_name();
					//파일 사이즈 담고
					fVO.setRfile_size(upload.getSize());
					//파일 DB에 저장
					try {
						//파일을 경로에 저장
						fVO.setRfile_path(path+fVO.getRsave_name());
						fVO.setRid(id);
						fDao.fileUpload(fVO);
						File outfile = new File(path+fVO.getRsave_name());
						if(!outfile.exists()){
			
							outfile.mkdirs();
			
						}
						//FileOutputStream fos = new FileOutputStream(outfile);
						upload.transferTo(outfile);
			//			InputStream is = upload.getInputStream();
			//			int readCount = 0;
						//byte[] buffer = upload.getBytes();
			//			while((readCount = is.read(buffer)) != -1) {
							//fos.write(buffer);
							//fos.close();
			//			}
					} catch (Exception e) {
						e.printStackTrace();
					}	
			//		red.addAttribute("check", 1);
			//		red.addAttribute("name", name);
			//		mv.setViewName("redirect:/uploadprocr.pino");
			//		return mv;
				} 
			}
	}
	
//	@RequestMapping(value="/uploadproc", method={ RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView uploadproc (ModelAndView mv, RedirectAttributes red,@RequestParam("check") int chk, @RequestParam("name") String name) {
//		int check = chk;
//		String tmp = name;
//		
//		if(check == 1) {
//			String filename = fDao.getImage(tmp);
//			String path = "\\resources\\images\\uploads\\"+filename;
//			red.addAttribute("path", path);
//			mv.setViewName("redirect:/fileupload.pino");
//			return mv;
//		} else {
//			throw new RuntimeException("sumtingwong");
//		}
//		
//	}
	
//	@RequestMapping(value="/uploadproc", method={ RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView uploadproc (ModelAndView mv, RedirectAttributes red,@RequestParam("check") int chk, @RequestParam("name") String name) {
//		int check = chk;
//		String tmp = name;
//		
//		if(check == 1) {
//			String filename = fDao.getImage(tmp);
//			String path = "\\resources\\images\\uploads\\"+filename;
//			red.addAttribute("path", path);
//			mv.setViewName("redirect:/register/register");
//			return mv;
//		} else {
//			throw new RuntimeException("sumtingwong");
//		}
//		
//	}
//	
//	@RequestMapping(value="/uploadprocr", method={ RequestMethod.GET, RequestMethod.POST })
//	public String uploadproc (ModelAndView mv, RedirectAttributes red,@RequestParam("check") int chk, @RequestParam("name") String name) {
//		int check = chk;
//		String tmp = name;
//		
//		if(check == 1) {
//			String filename = fDao.getImage(tmp);
//			String path = "\\resources\\images\\resume\\"+filename;
//			return path;
//		} else {
//			throw new RuntimeException("sumtingwong");
//		}
//		
//	}
	
//	@RequestMapping(value="/uploadproc", method={ RequestMethod.GET, RequestMethod.POST })
//	public void uploadproc (ModelAndView mv, HttpServletResponse r, RedirectAttributes red,@RequestParam("check") int chk, @RequestParam("name") String name) {
//		int check = chk;
//		String tmp = name;
//		
//		if(check == 1) {
//			String filename = fDao.getImage(tmp);
//			String path = "\\resources\\images\\uploads\\"+filename;
//			try {
//				r.getWriter().println(path);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			throw new RuntimeException("sumtingwong");
//		}
//		
//	}
	
	
	
	
}	
