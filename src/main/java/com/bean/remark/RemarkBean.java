package com.bean.remark;

import java.sql.Blob;

public class RemarkBean 
{
	private int rId;
	private int rDescipline;
	private int rTask;
	private int rGrasp;
	private int rRegular;
	private int rResearch;
	private int rExam;
	private String sName;
	private int sId;
	private byte[] rPdf;
	
	
	public byte[] getrPdf() {
		return rPdf;
	}
	public void setrPdf(byte[] rPdf) {
		this.rPdf = rPdf;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getrDescipline() {
		return rDescipline;
	}
	public void setrDescipline(int rDescipline) {
		this.rDescipline = rDescipline;
	}
	public int getrTask() {
		return rTask;
	}
	public void setrTask(int rTask) {
		this.rTask = rTask;
	}
	public int getrGrasp() {
		return rGrasp;
	}
	public void setrGrasp(int rGrasp) {
		this.rGrasp = rGrasp;
	}
	public int getrRegular() {
		return rRegular;
	}
	public void setrRegular(int rRegular) {
		this.rRegular = rRegular;
	}
	public int getrResearch() {
		return rResearch;
	}
	public void setrResearch(int rResearch) {
		this.rResearch = rResearch;
	}
	public int getrExam() {
		return rExam;
	}
	public void setrExam(int rExam) {
		this.rExam = rExam;
	}
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
}
