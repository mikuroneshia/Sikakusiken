package test;

public class oracleJavaDaoTest{
	public static void main(String[]args) {
		//test();
		String[] answers= {"C","A","A,C,D","B","C","A","A","B","A","D","B","D","A","A","B","C","A","A,B,C,D,F,G","A,B",
				"C,","B","D"};
		System.out.println(answers.length);
	}
	/*public static void test() {
		GetQuestionInfoLogic gqil=new GetQuestionInfoLogic();
		List<QuestionInfo>questionList=gqil.execute("1");
		for(QuestionInfo question:questionList) {
			System.out.println(question.getChapter()+"-"+question.getNumber());
		}
	}*/
}
