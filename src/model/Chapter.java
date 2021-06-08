package model;

import java.io.Serializable;

public class Chapter implements Serializable{
	private String textbook;
	private String chapter;
	public Chapter() {}
	public Chapter(String textbook,String chapter) {
		this.textbook=textbook;
		this.chapter=chapter;
	}
	public String getTextbook() {return this.textbook;}
	public String getChapter() {return this.chapter;}
}
