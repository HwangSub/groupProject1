package com.myhome.dto;

import lombok.Data;

@Data
public class NboardDto {

	private int seqid;
	private String title;
	private String pass;
	private String writer;
	private String content;
	private int hits;
	private String rdate;
	private String udate;
	
	// 다음 seqid 값
	private int nseqid;
	
	// 이전 seqid 값
	private int bseqid;
	
	// 강조
	private String emsis = "N";

	public String getEmsis() {
		return emsis;
	}
	public void setEmsis(String emsis) {
		this.emsis = emsis;
	}
	public int getNseqid() {
		return nseqid;
	}
	public void setNseqid(int nseqid) {
		this.nseqid = nseqid;
	}
	public int getBseqid() {
		return bseqid;
	}
	public void setBseqid(int bseqid) {
		this.bseqid = bseqid;
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
}
