package model;
import java.io.Serializable;
import java.util.List;

public class DBTable implements Serializable{
	private String name;
	private String chapter;
	private List<Integer> number;
	private String[] answers;
	private List<String> judge;

	public DBTable(){}
	public DBTable(String name,String chapter,List<Integer> number,String[] answers,List<String> judge) {
		this.name=name;
		this.chapter=chapter;
		this.number=number;
		this.answers=answers;
		this.judge=judge;
	}
	public String getName() {return this.name;}
	public String getChapter(){return this.chapter;}
	public List<Integer> getNumber() {return this.number;}
	public String[] getAnswers() {return this.answers;}
	public List<String> getJudge() {return this.judge;}
}
