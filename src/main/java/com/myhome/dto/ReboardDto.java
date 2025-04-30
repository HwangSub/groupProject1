package com.myhome.dto;

import lombok.Data;

@Data
public class ReboardDto {

	int seqid;
	String cmmt;
	String pass;
	String writer;
	String rdate;
	int pseqid;
	int star;

	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getSeqid() {
		return seqid;
	}
	public void setSeqid(int seqid) {
		this.seqid = seqid;
	}
	public String getCmmt() {
		return cmmt;
	}
	public void setCmmt(String cmmt) {
		this.cmmt = cmmt;
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
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getPseqid() {
		return pseqid;
	}
	public void setPseqid(int pseqid) {
		this.pseqid = pseqid;
	}
}
