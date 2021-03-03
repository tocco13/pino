package com.pinosoft.test.vo;

public class FileVO {
	private int seq;
	private String id;
	private String file_type;
	private String file_path;
	private String org_name;
	private String save_name;
	private String file_name;
	private long file_size;

	public FileVO() {
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getSave_name() {
		return save_name;
	}

	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "FileVO [seq=" + seq + ", id=" + id + ", file_type=" + file_type + ", file_path=" + file_path
				+ ", org_name=" + org_name + ", save_name=" + save_name + ", file_name=" + file_name + ", file_size="
				+ file_size + "]";
	}


}
