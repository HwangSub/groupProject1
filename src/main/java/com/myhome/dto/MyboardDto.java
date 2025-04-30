package com.myhome.dto;

import lombok.Data;

@Data
public class MyboardDto {

	int seqid;
	String title;
	String pass;
	String writer;
	String content;
	String rdate;
	String udate;
	int hits;
	
	// 이전 고유번호
	int bseqid;
	// 다음 고유번호
	int nseqid;

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
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}

}
