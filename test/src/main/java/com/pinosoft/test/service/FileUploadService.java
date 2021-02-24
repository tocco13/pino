package com.pinosoft.test.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.*;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "/upload";
	private static final String PREFIX_URL = "/upload/";
	
	public String restore (MultipartFile multipartFile) {
		String url = null;
		
		try {
			//파일 정보
			String originFilename = multipartFile.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			//서버에서 저장할 파일 이름
			String saveFileName = genSaveFileName(extName);
			System.out.println("originFileName : " + originFilename);
			System.out.println("extensionName : "+ extName);
			System.out.println("file size : "+size);
			System.out.println("saveFilename : "+ saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return url;
		
	}
	
	private String genSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		
		return fileName;
	}
	
	private boolean writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		boolean result = false;
		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/"+saveFileName);
		fos.write(data);
		fos.close();
		
		return result;
	}
}
