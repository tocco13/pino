package com.pinosoft.test.vo;

import java.sql.Date;

public class InsaVO {
	private int sabun; //사번 int
	private String join_day; //입사일 string
	private String retire_day ; //퇴사일 string
	private String put_yn ; //투입여부 string
	private String name ; //이름 string
	private String reg_no ; //주민번호 string
	private String eng_name ; //영명 string
	private String phone ; //전번 string
	private String hp ; //핸드폰 string
	private String pos_gbn_code ; //직위 string
	private String cmp_reg_no ; //사업자등록번호 string
	private String cmp_reg_image ; //사업자등록증 이미지 string
	private String sex ; //성별 string
	private int years ; //연령 int
	private String email ; //이메일 string
	private int zip ; //우편번호 int
	private String addr1 ; //주소 string
	private String addr2 ; //세부주소 string
	private String dept_code ; //부서 string
	private String id ; //아이디 string
	private String pwd ; //비번 string
	private int salary ; //연봉 int
	private String kosa_reg_yn ; //kosa등록여부 string
	private String kosa_class_code ; //kosa 등급 string
	private String mil_yn ; //입대여부 string
	private String mil_type ; //군별 string
	private String mil_level ; //계급 string
	private String mil_startdate ; //입대일 string
	private String mil_enddate ; //전역일 string
	private String job_type ; //직종 string
	private String gart_level ; //등급 string
	private String self_intro ; // 자기소개 string
	private String crm_name ; //업체명 string
	private String profile ; //프로필 이미지 string
	private String resume ; //이력서 이미지 string
	private String current_yn ; //입사여부 string
	private String emailprovider; //이메일 확장자용
	private Date jsetDate, rsetDate;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJoin_day() {
		return join_day;
	}
	public void setJoin_day(String join_day) {
		this.join_day = join_day;
	}
	public String getRetire_day() {
		return retire_day;
	}
	public void setRetire_day(String retire_day) {
		this.retire_day = retire_day;
	}
	public String getPut_yn() {
		return put_yn;
	}
	public void setPut_yn(String put_yn) {
		this.put_yn = put_yn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getEng_name() {
		return eng_name;
	}
	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getPos_gbn_code() {
		return pos_gbn_code;
	}
	public void setPos_gbn_code(String pos_gbn_code) {
		this.pos_gbn_code = pos_gbn_code;
	}
	public String getCmp_reg_no() {
		return cmp_reg_no;
	}
	public void setCmp_reg_no(String cmp_reg_no) {
		this.cmp_reg_no = cmp_reg_no;
	}
	public String getCmp_reg_image() {
		return cmp_reg_image;
	}
	public void setCmp_reg_image(String cmp_reg_image) {
		this.cmp_reg_image = cmp_reg_image;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getKosa_reg_yn() {
		return kosa_reg_yn;
	}
	public void setKosa_reg_yn(String kosa_reg_yn) {
		this.kosa_reg_yn = kosa_reg_yn;
	}
	public String getKosa_class_code() {
		return kosa_class_code;
	}
	public void setKosa_class_code(String kosa_class_code) {
		this.kosa_class_code = kosa_class_code;
	}
	public String getMil_yn() {
		return mil_yn;
	}
	public void setMil_yn(String mil_yn) {
		this.mil_yn = mil_yn;
	}
	public String getMil_type() {
		return mil_type;
	}
	public void setMil_type(String mil_type) {
		this.mil_type = mil_type;
	}
	public String getMil_level() {
		return mil_level;
	}
	public void setMil_level(String mil_level) {
		this.mil_level = mil_level;
	}
	public String getMil_startdate() {
		return mil_startdate;
	}
	public void setMil_startdate(String mil_startdate) {
		this.mil_startdate = mil_startdate;
	}
	public String getMil_enddate() {
		return mil_enddate;
	}
	public void setMil_enddate(String mil_enddate) {
		this.mil_enddate = mil_enddate;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	public String getGart_level() {
		return gart_level;
	}
	public void setGart_level(String gart_level) {
		this.gart_level = gart_level;
	}
	public String getSelf_intro() {
		return self_intro;
	}
	public void setSelf_intro(String self_intro) {
		this.self_intro = self_intro;
	}
	public String getCrm_name() {
		return crm_name;
	}
	public void setCrm_name(String crm_name) {
		this.crm_name = crm_name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Date getJsetDate() {
		return jsetDate;
	}
	public void setJsetDate(Date jsetDate) {
		this.jsetDate = jsetDate;
	}
	public Date getRsetDate() {
		return rsetDate;
	}
	public void setRsetDate(Date rsetDate) {
		this.rsetDate = rsetDate;
	}
	public String getCurrent_yn() {
		return current_yn;
	}
	public void setCurrent_yn(String current_yn) {
		this.current_yn = current_yn;
	}
	public String getEmailprovider() {
		return emailprovider;
	}
	public void setEmailprovider(String emailprovider) {
		this.emailprovider = emailprovider;
	}

	
	
}
