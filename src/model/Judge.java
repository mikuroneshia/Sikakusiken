package model;

import java.util.ArrayList;
import java.util.List;

public class Judge {
	public List<String> judgeLogic(String[] answers,List<String>collectAnswers){
		List<String> judgeList=new ArrayList<>();
		for(int i=0;i<answers.length;i++) {
			if(answers[i].equals(collectAnswers.get(i))) {
				judgeList.add("正解");
			}else {
				judgeList.add("不正解");
			}
		}
		return judgeList;
	}
}
