package model;

import java.io.Serializable;


public class QuestionInfo implements Serializable{
	private int chapter;
	private int number;
	private String answer;

	public QuestionInfo() {}
	public QuestionInfo(int chapter,int number) {
		this.chapter=chapter;
		this.number=number;
	}
	public QuestionInfo(int chapter,int number,String answer) {
		this.chapter=chapter;
		this.number=number;
		this.answer=answer;
	}
	public int getChapter() {return this.chapter;}
	public int getNumber() {return this.number;}
	public String getAnswer() {return this.answer;}
	public void setChapter(int chapter) {this.chapter=chapter;}
	public void setNumber(int number) {this.number=number;}
	public void setAnswer(String answer) {this.answer=answer;}

}
