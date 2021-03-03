package com.pinosoft.test.vo;

public class FileVOB {
	private int bseq;
	private String bid;
	private String bfile_type;
	private String bfile_path;
	private String borg_name;
	private String bsave_name;
	private String bfile_name;
	private long bfile_size;

	public FileVOB() {
	}

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBfile_type() {
		return bfile_type;
	}

	public void setBfile_type(String bfile_type) {
		this.bfile_type = bfile_type;
	}

	public String getBfile_path() {
		return bfile_path;
	}

	public void setBfile_path(String bfile_path) {
		this.bfile_path = bfile_path;
	}

	public String getBorg_name() {
		return borg_name;
	}

	public void setBorg_name(String borg_name) {
		this.borg_name = borg_name;
	}

	public String getBsave_name() {
		return bsave_name;
	}

	public void setBsave_name(String bsave_name) {
		this.bsave_name = bsave_name;
	}

	public String getBfile_name() {
		return bfile_name;
	}

	public void setBfile_name(String bfile_name) {
		this.bfile_name = bfile_name;
	}

	public long getBfile_size() {
		return bfile_size;
	}

	public void setBfile_size(long bfile_size) {
		this.bfile_size = bfile_size;
	}

	@Override
	public String toString() {
		return "FileVOB [bseq=" + bseq + ", bid=" + bid + ", bfile_type=" + bfile_type + ", bfile_path=" + bfile_path
				+ ", borg_name=" + borg_name + ", bsave_name=" + bsave_name + ", bfile_name=" + bfile_name
				+ ", bfile_size=" + bfile_size + "]";
	}

	

}
