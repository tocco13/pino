package com.pinosoft.test.vo;

public class FileVOR {
	private int rseq;
	private String rid;
	private String rfile_type;
	private String rfile_path;
	private String rorg_name;
	private String rsave_name;
	private String rfile_name;
	private long rfile_size;

	public FileVOR() {
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRfile_type() {
		return rfile_type;
	}

	public void setRfile_type(String rfile_type) {
		this.rfile_type = rfile_type;
	}

	public String getRfile_path() {
		return rfile_path;
	}

	public void setRfile_path(String rfile_path) {
		this.rfile_path = rfile_path;
	}

	public String getRorg_name() {
		return rorg_name;
	}

	public void setRorg_name(String rorg_name) {
		this.rorg_name = rorg_name;
	}

	public String getRsave_name() {
		return rsave_name;
	}

	public void setRsave_name(String rsave_name) {
		this.rsave_name = rsave_name;
	}

	public String getRfile_name() {
		return rfile_name;
	}

	public void setRfile_name(String rfile_name) {
		this.rfile_name = rfile_name;
	}

	public long getRfile_size() {
		return rfile_size;
	}

	public void setRfile_size(long rfile_size) {
		this.rfile_size = rfile_size;
	}

	@Override
	public String toString() {
		return "FileVOR [rseq=" + rseq + ", rid=" + rid + ", rfile_type=" + rfile_type + ", rfile_path=" + rfile_path
				+ ", rorg_name=" + rorg_name + ", rsave_name=" + rsave_name + ", rfile_name=" + rfile_name
				+ ", rfile_size=" + rfile_size + "]";
	}
	
	


}
