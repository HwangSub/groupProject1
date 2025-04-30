package com.myhome.dto;

public class DataDto {
	
	int seqid;
	String title = "";
	String pass = "";
	String writer = "";
	String content = "";
	int hits;
	String rdate = "";
	String udate = "";
	String filepath = "";
	String filename = "";

	int filesize = 0;
	
	int bseqid = 0;
	int nseqid = 0;

	public int getBseqid() {
		return bseqid;
	}
	public void setBseqid(int bseqid) {
		this.bseqid = bseqid;
	}
	public int getNseqid() {
		return nseqid;
	}
	public void setNseqid(int nseqid) {
		this.nseqid = nseqid;
	}
	public int getSeqid() {
		return seqid;
	}
	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

}



