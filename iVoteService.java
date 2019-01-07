package Assignment1;
import java.util.*;
public class iVoteService{
	
	Random random; boolean questionType;
	//Give each student a unique student ID
	Students s1 = new Students("1111");
	Students s2 = new Students("2222");
	Students s3 = new Students("3333");
	Students s4 = new Students("4444");
	Students s5 = new Students("5555"); 
	Students s6 = new Students("6666");
	Students s7 = new Students("7777");
	Students s8 = new Students("8888");
	Students s9 = new Students("9999");
	Students s10 = new Students("1010");
	
	//Put student into the array list of students
	Students[] listOfStudents = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
	char[] answerChoices = {'A','B','C','D','T','F'};
	
	/*
	 * HashMap<String,Character> StudentSubmissions selects random answer from student
	 */
	public HashMap<String,Character> StudentSubmissions(){
		//Create new object classes
		Question multipleChoice = new MC_Question();
		Question trueOrFalse = new TF_Question();
		//Put Types of Question into the array
		Question[] question = {multipleChoice, trueOrFalse};
		//Choose one of the two questions
		if(question[random.nextInt(2)] == multipleChoice){
			questionType = true;
			multipleChoice.QuestionType();
		}
		else{
			questionType = false;
			trueOrFalse.QuestionType();
		}
		
		//Create HashMap for StudentID and studentSelection
		HashMap<String,Character> studentSubmissions = new HashMap<String,Character>();
		int randNum;
		//Do random method to get random answer for each question
		for (int i = 0; i < 10; i++) {
			if (questionType){
				randNum = random.nextInt(4);
			}else{
				randNum = 3 + random.nextInt(2);
			}
			studentSubmissions.put(listOfStudents[i].getID(), answerChoices[randNum]);
		}
		return studentSubmissions;
	}
	/*
	 * printStudentAnswers prints answers chosen by students
	 */
	public void printStudentAnswers(HashMap<String,Character> hashMap){
		int numOf_A = 0,numOf_B = 0,numOf_C = 0,numOf_D = 0;
		if(questionType){
			for (Character selection : hashMap.values()) {
				if (selection =='A')
					numOf_A++;
				else if (selection =='B')
					numOf_B++;
				else if (selection =='C')
					numOf_C++;
				else if (selection =='D')
					numOf_D++; 
			}
			System.out.println("The result:");
			System.out.println("> Numbers of A: " + numOf_A);
			System.out.println("> Numbers of B: " + numOf_B);
			System.out.println("> Numbers of C: " + numOf_C);
			System.out.println("> Numbers of D: " + numOf_D);
			
		} else {
			int numOf_T = 0,numOf_F = 0;
			for (Character selection : hashMap.values()) {
				if (selection == 'T')
					numOf_T++;
				else
					numOf_F++;
			}
			System.out.println("The result:");
			System.out.println("> Numbers of True: " + numOf_T);
			System.out.println("> Numbers of False: "+ numOf_F);
		}
	}
	public iVoteService(){
		random = new Random();
	}
}